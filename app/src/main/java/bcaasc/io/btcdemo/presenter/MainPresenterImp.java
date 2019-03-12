package bcaasc.io.btcdemo.presenter;

import bcaasc.io.btcdemo.bean.Tx;
import bcaasc.io.btcdemo.bean.TxRef;
import bcaasc.io.btcdemo.constants.BTCParamsConstants;
import bcaasc.io.btcdemo.contact.MainContact;
import bcaasc.io.btcdemo.http.MainRequester;
import bcaasc.io.btcdemo.http.callback.BaseCallback;
import bcaasc.io.btcdemo.tool.LogTool;
import com.google.gson.JsonObject;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.bitcoinj.core.*;
import org.bitcoinj.script.Script;
import org.spongycastle.util.encoders.Hex;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author catherine.brainwilliam
 * @since 2018/11/12
 */
public class MainPresenterImp implements MainContact.Presenter {

    private String TAG = MainPresenterImp.class.getSimpleName();

    private MainRequester requester = new MainRequester();
    private MainContact.View view;
    private List<TxRef> btcUTXOList;


    private String transactionRaw, transactionHash;


    public MainPresenterImp(MainContact.View view) {
        this.view = view;
    }

    @Override
    public void getBalance(String address) {
        requester.getBalance(address, new Callback<bcaasc.io.btcdemo.bean.Address>() {
            @Override
            public void onResponse(Call<bcaasc.io.btcdemo.bean.Address> call, Response<bcaasc.io.btcdemo.bean.Address> response) {
                bcaasc.io.btcdemo.bean.Address address = response.body();
                LogTool.d(TAG, address);
                if (address != null) {
                    long finalBalance = address.getFinal_balance();
                    view.getBalanceSuccess(String.valueOf(new BigDecimal(finalBalance).multiply(new BigDecimal(BTCParamsConstants.BtcUnitRevert))));
                } else {
                    view.getBalanceFailure("balance 数据为空！");

                }
            }

            @Override
            public void onFailure(Call<bcaasc.io.btcdemo.bean.Address> call, Throwable t) {
                LogTool.e(TAG, t.getMessage());
                view.getBalanceFailure(t.getMessage());
            }

        });

    }

    /**
     * 获取BTC交易记录数据
     *
     * @return
     */
    @Override
    public void getTransactionList(String address) {
        requester.getTXList(address, new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                LogTool.d(TAG, response.body());
                view.success(response.body());

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                LogTool.e(TAG, t.getMessage());
                view.success(t.getMessage());
            }
        });
    }

    /**
     * 获取UTXO事务
     *
     * @return
     */
    @Override
    public void getUnspent(String address, String amount, String fee, String addressTo, String privateKey) {
        requester.getUnspent(address, new Callback<bcaasc.io.btcdemo.bean.Address>() {
            @Override
            public void onResponse(Call<bcaasc.io.btcdemo.bean.Address> call, Response<bcaasc.io.btcdemo.bean.Address> response) {
                bcaasc.io.btcdemo.bean.Address address = response.body();
                LogTool.d(TAG, address);

                if (address != null) {
                    //这是已经确认的交易
                    btcUTXOList = address.getTxrefs();
                    if (btcUTXOList == null) {
                        btcUTXOList = address.getUnconfirmed_txrefs();//这是未经确认的交易
                    }
                    if (btcUTXOList == null) {
                        view.failure("没有UTXO");
                        return;
                    }
                    //排序UTXO  从大到小
                    Collections.sort(btcUTXOList, (unspentOutput, t1) -> Long.compare(t1.getValue(), unspentOutput.getValue()));
                    view.success(btcUTXOList.toString());
                    LogTool.d(TAG, "发送地址：" + address);
                    LogTool.d(TAG, "接受地址：" + addressTo);
                    LogTool.d(TAG, "发送金额：" + amount);
                    LogTool.d(TAG, "发送手续费：" + fee);
                    pushTX(fee, addressTo, amount, privateKey);
                }
            }

            @Override
            public void onFailure(Call<bcaasc.io.btcdemo.bean.Address> call, Throwable t) {
                LogTool.e(TAG, t.getMessage());
                view.failure(t.getMessage());

            }

        });
    }

    @Override
    public void getTXInfoByHash(String rawHash) {
        rawHash = "c1035de1e955be89908d4386c79cb5de41e4284dfc853f49477c5a648930c6c1";
        if (rawHash == "" || rawHash == null) {
            rawHash = transactionHash;
        }
        requester.getTXInfoByHash(rawHash, new BaseCallback<Tx>() {

                    @Override
                    public void httpException() {
                        super.httpException();
                        view.failure("Transaction not found");
                    }

                    @Override
                    public void onSuccess(Response<Tx> response) {
                        LogTool.d(TAG, response.body());
                        Tx tx = response.body();
                        if (tx != null) {
                            view.success("当前区块的高度为：" + tx.getBlock_height());

                        }
                    }

                    @Override
                    public void onFailure(Call<Tx> call, Throwable t) {
                        t.printStackTrace();
                        LogTool.e(TAG, t.getMessage());
                        view.failure(t.getMessage());
                    }

                    @Override
                    public void onNotFound() {
                        super.onNotFound();
                        view.failure("not found");
                    }
                }
        );
    }

    /**
     * 转账BTC方法
     *
     * @param feeString    手续费
     * @param toAddress    收款地址
     * @param amountString 转账数量
     *                     <p>
     *                     0.00001
     * @return
     */
    @Override
    public void pushTX(String feeString, String toAddress, String amountString, String addressPrivateKey) {
        //判断当前是否有UTXO事务
        if (btcUTXOList == null) {
            return;
        }
        //You must construct a Context object before using BitCoin j!
        Context.getOrCreate(BTCParamsConstants.getNetworkParameter());
        //声明一个地址
        Address addressToSend = null;
        try {
            //将当前传入的地址转化成特定的地址格式
            addressToSend = Address.fromBase58(BTCParamsConstants.getNetworkParameter(), toAddress);
        } catch (AddressFormatException a) {
            LogTool.e(TAG, a.getMessage());
        }
        LogTool.d(TAG, "fee:" + feeString);
        //因为BTC内部的单位是「聪」10^8,所以，这里需要对刚传入的金额和利息参数进行换算
        BigDecimal amount = new BigDecimal(amountString).multiply(new BigDecimal(BTCParamsConstants.BtcUnit));
        BigDecimal fee;
        //判断当前用户是否给予手续费，否则采用本APP默认的手续费规则
        if (feeString == "" || feeString == null) {
            fee = new BigDecimal("0.005").multiply(new BigDecimal(BTCParamsConstants.BtcUnit));
        } else {
            fee = new BigDecimal(feeString).multiply(new BigDecimal(BTCParamsConstants.BtcUnit));
        }
        //判断当前单位换算过的fee是否满足要求，否则也按照给定的规则计算手续费
        if (fee.doubleValue() <= 0) {
            fee = new BigDecimal("0.005").multiply(new BigDecimal(BTCParamsConstants.BtcUnit));
        }
        //声明一个变量用于得到待会取出UTXO需要用来支付的的「输入」
        BigDecimal walletBtc = new BigDecimal("0.0");
        //获取当前设定环境下的Transaction实例
        Transaction transaction = new Transaction(BTCParamsConstants.getNetworkParameter());
        //添加「输出」的金额以及地址信息
        transaction.addOutput(Coin.valueOf((amount.longValue())), addressToSend);
        //将当前交易的金额+手续费
        amount = amount.add(fee);
        //重新声明一个UTXO数组
        List<TxRef> btcUnspentOutputList = new ArrayList<>();
        //遍历UTXO，得到当前地址的所有UTXO事务
        for (int i = 0; i < btcUTXOList.size(); i++) {
            TxRef unspentOutput = btcUTXOList.get(i);
            //添加当前的UTXO里面的value
            walletBtc = walletBtc.add(new BigDecimal(unspentOutput.getValue()));
            //将当前数据新添加入新定义的UTXO数组里面
            btcUnspentOutputList.add(unspentOutput);
//            //比较当前账户的btc是否大于等于这次需要push的金额
            if (walletBtc.doubleValue() >= amount.doubleValue()) {
                break;
            }
        }
        LogTool.d(TAG, "walletBtc:" + walletBtc);
        LogTool.d(TAG, "amount:" + amount);
        //比较当前账户的balance的double值是否大于这次需要push的金额double值
        if (walletBtc.doubleValue() < amount.doubleValue()) {
            view.failure("insufficient_transaction");
            return;
        }
        //得到这次传送之后剩下的btc
        BigDecimal goBackBtc = walletBtc.subtract(amount);
        // 根据私鑰WIF字串轉ECKey
        ECKey ecKey = DumpedPrivateKey.fromBase58(BTCParamsConstants.getNetworkParameter(), addressPrivateKey).getKey();
        //判断当前剩下的btc不为0
        if (goBackBtc.doubleValue() != 0.0) {
            //添加「找零」的金额和地址
            transaction.addOutput(Coin.valueOf((goBackBtc.longValue())), ecKey.toAddress(BTCParamsConstants.getNetworkParameter()));
        }
        LogTool.d(TAG, "goBackBtc = " + goBackBtc);
        LogTool.d(TAG, "unspentOutputs.size :" + btcUnspentOutputList.size() + ";unspentOutputs: " + btcUnspentOutputList);
        //对重新组装的UTXO进行遍历,进行交易签章
        for (TxRef unspentOutput : btcUnspentOutputList) {
            if (unspentOutput.getValue() != 0.0) {
                // 获取交易输入TXId对应的交易数据
                Sha256Hash sha256Hash = new Sha256Hash(Utils.parseAsHexOrBase58(unspentOutput.getTx_hash()));
                // 获取交易输入所对应的上一笔交易中的交易输出
                TransactionOutPoint outPoint = new TransactionOutPoint(BTCParamsConstants.getNetworkParameter(),
                        unspentOutput.getTx_output_n(), sha256Hash);
                //获取当前script进行格式解析
                Script script = new Script(Utils.parseAsHexOrBase58(unspentOutput.getScript()));
                LogTool.d(TAG, "script:" + unspentOutput.getScript());
                LogTool.d(TAG, "script2:" + script);
                LogTool.d(TAG, "addSignedInput getTxid:" + unspentOutput.getTx_hash());
                LogTool.d(TAG, "addSignedInput getSatoshis:" + unspentOutput.getValue());
                //添加「交易」信息
                transaction.addSignedInput(outPoint, script, ecKey, Transaction.SigHash.ALL, true);
            }
        }
        transaction.getConfidence().setSource(TransactionConfidence.Source.SELF);
        transaction.setPurpose(Transaction.Purpose.USER_PAYMENT);

        LogTool.d(TAG, "transaction is:" + transaction);
        byte[] bytes = transaction.unsafeBitcoinSerialize();
        LogTool.d(TAG, "Transaction size = " + bytes.length);
        transactionRaw = Hex.toHexString(bytes);
        LogTool.d(TAG, "transactionRaw:" + transactionRaw);
        transactionHash = transaction.getHashAsString();
        view.setHashRaw(transactionHash);
        LogTool.d(TAG, "transactionHash:" + transactionHash);
        pushTX();
    }

    /**
     * 广播交易
     */
    private void pushTX() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("tx", transactionRaw);
        requester.pushTX(RequestBody.create(MediaType.parse("application/json"), jsonObject.toString()), new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                //Transaction Submitted
                LogTool.d(TAG, response.body());
                view.success(response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable responseThrowable) {
                LogTool.e(TAG, responseThrowable.getMessage());
                String message = responseThrowable.getMessage();
                view.failure(responseThrowable.getMessage());

//                int errorCode = responseThrowable.;
//                LogTool.e(TAG, "Error Message = " + message);
//                LogTool.e(TAG, "Error Code = " + errorCode);
//                if (message != null) {
//                    if (errorCode == TRANSFER_ERROR_ONE) {
//                        e.onError(responseThrowable);
//                    } else {
//                        try {
//                            JSONObject jsonObject = new JSONObject(message);
//                            JSONObject errorObject = jsonObject.optJSONObject("error");
//                            if (errorObject != null) {
//                                int code = errorObject.optInt("code");
//                                String errorMessage = errorObject.optString("message");
//                                if (code == -26) {
//                                    BigDecimal newFee = delivery.add(oldFee);
//                                    String error = delivery.toPlainString();
//                                    String errorValue = String.format(mContext.getString(R.string.transfer_error_too_low_value), error);
//                                    LogTool.e(TAG, "转账剩余qtum太低  value = " + delivery + " oldFee = " + oldFee + " 新的fee = " + newFee);
//                                    ExceptionHandle.ResponseThrowable responseThrowable1 = new ExceptionHandle.ResponseThrowable(errorValue, TRANSFER_ERROR_TWO, newFee, amountString, toAddress);
//                                    e.onError(responseThrowable1);
//                                } else {
//                                    e.onError(new ExceptionHandle.ResponseThrowable(errorMessage, TRANSFER_ERROR_TWO));
//                                }
//                                TransactionTokenViewModel.sendTransferError(mContext, TAG, CommonUtility.formatString(code), errorMessage, feeString, mFeePerKb.toString(),
//                                        getFromUtxo(), "0", "0", mTransactionHash, mTransactionRaw);
//                            }
//                        } catch (JSONException e1) {
//                            e1.printStackTrace();
//                            e.onError(new ExceptionHandle.ResponseThrowable(message, TRANSFER_ERROR_THREE));
//                        }
//                    }
//                } else {
//                    e.onError(new ExceptionHandle.ResponseThrowable(mContext.getString(R.string.failed), TRANSFER_ERROR_FOUR));
//                }
            }
        });
    }


}

package bcaasc.io.btcdemo.http;

import bcaasc.io.btcdemo.bean.Address;
import bcaasc.io.btcdemo.bean.Tx;
import bcaasc.io.btcdemo.bean.TxSkeleton;
import bcaasc.io.btcdemo.http.retrofit.RetrofitFactory;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;


/**
 * @author catherine.brainwilliam
 * @since 2018/11/13
 */
public class MainRequester {


    /**
     * 查询当前的余额
     *
     * @param address
     * @param callBackListener
     */
    public void getBalance(String address, Callback<Address> callBackListener) {
        HttpApi httpApi = RetrofitFactory.getInstance().create(HttpApi.class);
        Call<Address> call = httpApi.getBalance(address);
        call.enqueue(callBackListener);
    }

    /**
     * 获取当前钱包的信息
     *
     * @param address
     * @param callBackListener
     */
    public void getTXList(String address, Callback<String> callBackListener) {
        HttpApi httpApi = RetrofitFactory.getInstance().create(HttpApi.class);
        Call<String> call = httpApi.getAddressFullInfo(address);
        call.enqueue(callBackListener);
    }

    /**
     * 获取当前区块的状态
     *
     * @param rawHash
     * @param callBackListener
     */
    public void getTXInfoByHash(String rawHash, Callback<Tx> callBackListener) {
        HttpApi httpApi = RetrofitFactory.getInstance().create(HttpApi.class);
        Call<Tx> call = httpApi.getHashStatus(rawHash);
        call.enqueue(callBackListener);
    }


    /**
     * FirstMethod Step 1获取当前钱包的未交易区块
     *
     * @param address
     * @param callBackListener
     */
    public void getUnspent(String address, Callback<Address> callBackListener) {
        HttpApi httpApi = RetrofitFactory.getInstance().create(HttpApi.class);
        Call<Address> call = httpApi.getUnspentTransactionOutputs(address, true, true);
        call.enqueue(callBackListener);
    }

    /**
     * FirstMethod Step 2发送交易根据Raw
     *
     * @param rawHash
     * @param callBackListener
     */
    public void pushTX(RequestBody rawHash, Callback<String> callBackListener) {
        HttpApi httpApi = RetrofitFactory.getInstance().create(HttpApi.class);
        Call<String> call = httpApi.pushTX(rawHash);
        call.enqueue(callBackListener);
    }


    /**
     * SecondMethod Step 1获取创建交易
     *
     * @param body             组装的TX信息
     * @param callBackListener
     */
    public void createNewTX(RequestBody body, Callback<TxSkeleton> callBackListener) {
        HttpApi httpApi = RetrofitFactory.getInstance().create(HttpApi.class);
        Call<TxSkeleton> call = httpApi.createNewTx(body, true);
        call.enqueue(callBackListener);
    }

    /**
     * SecondMethod  Step 2发送交易
     *
     * @param rawHash          组装的TXSelection
     * @param callBackListener
     */
    public void sendTX(RequestBody rawHash, Callback<TxSkeleton> callBackListener) {
        HttpApi httpApi = RetrofitFactory.getInstance().create(HttpApi.class);
        Call<TxSkeleton> call = httpApi.sendTX(rawHash);
        call.enqueue(callBackListener);
    }


}

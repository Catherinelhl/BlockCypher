package bcaasc.io.btcdemo.contact;

import bcaasc.io.btcdemo.bean.TxSkeleton;

/**
 * @author catherine.brainwilliam
 * @since 2018/11/12
 */
public interface MainContact {
    interface View {
        void getBalanceSuccess(String balance);

        void getBalanceFailure(String info);

        void success(String info);

        void failure(String info);

        void hashStatus(String info);

        void setHashRaw(String hashRaw);
    }

    interface Presenter {

        void getBalance(String address);

        void getTransactionList(String address);

        void getUnspent(String address, String amount, String fee, String addressTo, String addressPrivateKey);

        void getTXInfoByHash(String rawHash);

        void createNewTxs(String inputAddress,String outputAddress,String amount,String privateKey);//Second Method to create a new txs

        void sendTxs(TxSkeleton txSkeleton,String privateKey);//Second Method to send the txs that by createNexTxs created.
    }
}

package bcaasc.io.btcdemo.http;

import bcaasc.io.btcdemo.bean.Address;
import bcaasc.io.btcdemo.bean.Tx;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.*;

public interface HttpApi {


    /*获取当前钱包的余额*/
    @GET("addrs/{address}/balance")
    Call<Address> getBalance(@Path("address") String address);

    /*获取当前钱包的信息*/
    @GET("addrs/{address}/full")
    Call<String> getAddressFullInfo(@Path("address") String address);


    /*获取当前区块的状态*/
    @GET("txs/{hash}")
    Call<Tx> getHashStatus(@Path("hash") String hash);


    /*获取当前钱包的未交易区块*/
    @GET("addrs/{address}")
    Call<Address> getUnspentTransactionOutputs(@Path("address") String address,
                                                                 @Query("unspentOnly") boolean unspentOnly,
                                                                 @Query("includeScript") boolean includeScript);

    /*获取创建交易*/
    @FormUrlEncoded
    @POST("txs/new")
    Call<String> createPushTx(@Body RequestBody body,@Field("includeToSignTx") boolean includeToSignTx);


    /*发送交易*/
    @FormUrlEncoded
    @POST("txs/send")
    Call<String> sendTX(@Body RequestBody TXSkeleton);

    /*发送交易根据Raw*/
//    @FormUrlEncoded
    @POST("txs/push")
    Call<String> pushTX(@Body RequestBody TXSkeleton);

}

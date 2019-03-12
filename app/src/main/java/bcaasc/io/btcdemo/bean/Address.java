package bcaasc.io.btcdemo.bean;
/*
+--------------+---------------------------------
+ author       +   Catherine Liu
+--------------+---------------------------------
+ since        +   2019/3/12 17:36
+--------------+---------------------------------
+ projectName  +   BlockCypher
+--------------+---------------------------------
+ packageName  +   bcaasc.io.btcdemo.bean
+--------------+---------------------------------
+ description  +  
+--------------+---------------------------------
+ version      +  
+--------------+---------------------------------
*/

import java.io.Serializable;
import java.util.List;

public class Address implements Serializable {
    private String address;
    private Wallet wallet;
    private int total_received;
    private int total_sent;
    private int balance;
    private int unconfirmed_balance;
    private int final_balance;
    private int n_tx;
    private int unconfirmed_n_tx;
    private int final_n_tx;
    private String tx_url;
    private List<Tx> txs;
    private List<TxRef> txrefs;
    private List<TxRef>  unconfirmed_txrefs;
    private boolean hasMore;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public int getTotal_received() {
        return total_received;
    }

    public void setTotal_received(int total_received) {
        this.total_received = total_received;
    }

    public int getTotal_sent() {
        return total_sent;
    }

    public void setTotal_sent(int total_sent) {
        this.total_sent = total_sent;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getUnconfirmed_balance() {
        return unconfirmed_balance;
    }

    public void setUnconfirmed_balance(int unconfirmed_balance) {
        this.unconfirmed_balance = unconfirmed_balance;
    }

    public int getFinal_balance() {
        return final_balance;
    }

    public void setFinal_balance(int final_balance) {
        this.final_balance = final_balance;
    }

    public int getN_tx() {
        return n_tx;
    }

    public void setN_tx(int n_tx) {
        this.n_tx = n_tx;
    }

    public int getUnconfirmed_n_tx() {
        return unconfirmed_n_tx;
    }

    public void setUnconfirmed_n_tx(int unconfirmed_n_tx) {
        this.unconfirmed_n_tx = unconfirmed_n_tx;
    }

    public int getFinal_n_tx() {
        return final_n_tx;
    }

    public void setFinal_n_tx(int final_n_tx) {
        this.final_n_tx = final_n_tx;
    }

    public String getTx_url() {
        return tx_url;
    }

    public void setTx_url(String tx_url) {
        this.tx_url = tx_url;
    }

    public List<Tx> getTxs() {
        return txs;
    }

    public void setTxs(List<Tx> txs) {
        this.txs = txs;
    }

    public List<TxRef> getTxrefs() {
        return txrefs;
    }

    public void setTxrefs(List<TxRef> txrefs) {
        this.txrefs = txrefs;
    }

    public List<TxRef> getUnconfirmed_txrefs() {
        return unconfirmed_txrefs;
    }

    public void setUnconfirmed_txrefs(List<TxRef> unconfirmed_txrefs) {
        this.unconfirmed_txrefs = unconfirmed_txrefs;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    @Override
    public String toString() {
        return "Address{" +
                "address='" + address + '\'' +
                ", wallet=" + wallet +
                ", total_received=" + total_received +
                ", total_sent=" + total_sent +
                ", balance=" + balance +
                ", unconfirmed_balance=" + unconfirmed_balance +
                ", final_balance=" + final_balance +
                ", n_tx=" + n_tx +
                ", unconfirmed_n_tx=" + unconfirmed_n_tx +
                ", final_n_tx=" + final_n_tx +
                ", tx_url=" + tx_url +
                ", txs=" + txs +
                ", txrefs=" + txrefs +
                ", unconfirmed_txrefs=" + unconfirmed_txrefs +
                ", hasMore=" + hasMore +
                '}';
    }
}

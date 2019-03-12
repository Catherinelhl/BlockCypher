package bcaasc.io.btcdemo.bean;
/*
+--------------+---------------------------------
+ author       +   Catherine Liu
+--------------+---------------------------------
+ since        +   2019/3/12 17:41
+--------------+---------------------------------
+ projectName  +   BlockCypher
+--------------+---------------------------------
+ packageName  +   bcaasc.io.btcdemo.bean
+--------------+---------------------------------
+ description  +  Array of transaction inputs and outputs for this address. Usually only returned from the standard Address Endpoint.
+--------------+---------------------------------
+ version      +  
+--------------+---------------------------------
*/

import java.io.Serializable;

public class TxRef implements Serializable {
    private String address;
    private int block_height;
    private String tx_hash;
    private int tx_input_n;
    private int tx_output_n;
    private int value;
    private String preference;
    private boolean spent;
    private boolean double_spend;
    private int confirmations;
    private String script;
    private int ref_balance;
    private float confidence;
    private String confirmed;
    private String spent_by;
    private String received;
    private int receive_count;
    private String double_of;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBlock_height() {
        return block_height;
    }

    public void setBlock_height(int block_height) {
        this.block_height = block_height;
    }

    public String getTx_hash() {
        return tx_hash;
    }

    public void setTx_hash(String tx_hash) {
        this.tx_hash = tx_hash;
    }

    public int getTx_input_n() {
        return tx_input_n;
    }

    public void setTx_input_n(int tx_input_n) {
        this.tx_input_n = tx_input_n;
    }

    public int getTx_output_n() {
        return tx_output_n;
    }

    public void setTx_output_n(int tx_output_n) {
        this.tx_output_n = tx_output_n;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }

    public boolean isSpent() {
        return spent;
    }

    public void setSpent(boolean spent) {
        this.spent = spent;
    }

    public boolean isDouble_spend() {
        return double_spend;
    }

    public void setDouble_spend(boolean double_spend) {
        this.double_spend = double_spend;
    }

    public int getConfirmations() {
        return confirmations;
    }

    public void setConfirmations(int confirmations) {
        this.confirmations = confirmations;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public int getRef_balance() {
        return ref_balance;
    }

    public void setRef_balance(int ref_balance) {
        this.ref_balance = ref_balance;
    }

    public float getConfidence() {
        return confidence;
    }

    public void setConfidence(float confidence) {
        this.confidence = confidence;
    }

    public String getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(String confirmed) {
        this.confirmed = confirmed;
    }

    public String getSpent_by() {
        return spent_by;
    }

    public void setSpent_by(String spent_by) {
        this.spent_by = spent_by;
    }

    public String getReceived() {
        return received;
    }

    public void setReceived(String received) {
        this.received = received;
    }

    public int getReceive_count() {
        return receive_count;
    }

    public void setReceive_count(int receive_count) {
        this.receive_count = receive_count;
    }

    public String getDouble_of() {
        return double_of;
    }

    public void setDouble_of(String double_of) {
        this.double_of = double_of;
    }

    @Override
    public String toString() {
        return "TxRef{" +
                "address='" + address + '\'' +
                ", block_height=" + block_height +
                ", tx_hash='" + tx_hash + '\'' +
                ", tx_input_n=" + tx_input_n +
                ", tx_output_n=" + tx_output_n +
                ", value=" + value +
                ", preference='" + preference + '\'' +
                ", spent=" + spent +
                ", double_spend=" + double_spend +
                ", confirmations=" + confirmations +
                ", script='" + script + '\'' +
                ", ref_balance=" + ref_balance +
                ", confidence=" + confidence +
                ", confirmed='" + confirmed + '\'' +
                ", spent_by='" + spent_by + '\'' +
                ", received='" + received + '\'' +
                ", receive_count=" + receive_count +
                ", double_of='" + double_of + '\'' +
                '}';
    }
}

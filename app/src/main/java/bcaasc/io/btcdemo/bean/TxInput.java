package bcaasc.io.btcdemo.bean;
/*
+--------------+---------------------------------
+ author       +   Catherine Liu
+--------------+---------------------------------
+ since        +   2019/3/12 17:47
+--------------+---------------------------------
+ projectName  +   BlockCypher
+--------------+---------------------------------
+ packageName  +   bcaasc.io.btcdemo.bean
+--------------+---------------------------------
+ description  +  A TXInput represents an input consumed within a transaction. Typically found within an array in a TX. In most cases, TXInputs are from previous UTXOs, with the most prominent exceptions being attempted double-spend and coinbase inputs.
+--------------+---------------------------------
+ version      +  
+--------------+---------------------------------
*/

import java.io.Serializable;
import java.util.List;

public class TxInput implements Serializable {
    private String prev_hash;
    private long output_index;
    private long output_value;
    private String script_type;
    private String script;
    private List<String> addresses;
    private long sequence;
    private int age;
    private String wallet_name;
    private String wallet_token;

    public String getPrev_hash() {
        return prev_hash;
    }

    public void setPrev_hash(String prev_hash) {
        this.prev_hash = prev_hash;
    }

    public long getOutput_index() {
        return output_index;
    }

    public void setOutput_index(long output_index) {
        this.output_index = output_index;
    }

    public long getOutput_value() {
        return output_value;
    }

    public void setOutput_value(long output_value) {
        this.output_value = output_value;
    }

    public String getScript_type() {
        return script_type;
    }

    public void setScript_type(String script_type) {
        this.script_type = script_type;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public List<String> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<String> addresses) {
        this.addresses = addresses;
    }

    public long getSequence() {
        return sequence;
    }

    public void setSequence(long sequence) {
        this.sequence = sequence;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getWallet_name() {
        return wallet_name;
    }

    public void setWallet_name(String wallet_name) {
        this.wallet_name = wallet_name;
    }

    public String getWallet_token() {
        return wallet_token;
    }

    public void setWallet_token(String wallet_token) {
        this.wallet_token = wallet_token;
    }

    @Override
    public String toString() {
        return "TxInput{" +
                "prev_hash='" + prev_hash + '\'' +
                ", output_index=" + output_index +
                ", output_value=" + output_value +
                ", script_type='" + script_type + '\'' +
                ", script='" + script + '\'' +
                ", addresses=" + addresses +
                ", sequence=" + sequence +
                ", age=" + age +
                ", wallet_name='" + wallet_name + '\'' +
                ", wallet_token='" + wallet_token + '\'' +
                '}';
    }
}

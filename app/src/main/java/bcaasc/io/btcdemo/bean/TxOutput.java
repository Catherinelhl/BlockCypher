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
+ description  +  A TXOutput represents an output created by a transaction. Typically found within an array in a TX.
+--------------+---------------------------------
+ version      +  
+--------------+---------------------------------
*/

import java.io.Serializable;
import java.util.List;

public class TxOutput implements Serializable {
    private int value;
    private String script;
    private List<String> addresses;
    private String script_type;
    private String spent_by;
    private String data_hex;
    private String data_string;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
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

    public String getScript_type() {
        return script_type;
    }

    public void setScript_type(String script_type) {
        this.script_type = script_type;
    }

    public String getSpent_by() {
        return spent_by;
    }

    public void setSpent_by(String spent_by) {
        this.spent_by = spent_by;
    }

    public String getData_hex() {
        return data_hex;
    }

    public void setData_hex(String data_hex) {
        this.data_hex = data_hex;
    }

    public String getData_string() {
        return data_string;
    }

    public void setData_string(String data_string) {
        this.data_string = data_string;
    }

    @Override
    public String toString() {
        return "TxOutput{" +
                "value=" + value +
                ", script='" + script + '\'' +
                ", addresses=" + addresses +
                ", script_type='" + script_type + '\'' +
                ", spent_by='" + spent_by + '\'' +
                ", data_hex='" + data_hex + '\'' +
                ", data_string='" + data_string + '\'' +
                '}';
    }
}

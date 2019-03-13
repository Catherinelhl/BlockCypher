package bcaasc.io.btcdemo.bean;
/*
+--------------+---------------------------------
+ author       +   Catherine Liu
+--------------+---------------------------------
+ since        +   2019/3/13 14:21
+--------------+---------------------------------
+ projectName  +   BlockCypher
+--------------+---------------------------------
+ packageName  +   bcaasc.io.btcdemo.bean
+--------------+---------------------------------
+ description  +   A TXSkeleton is a convenience/wrapper Object that’s used primarily when Creating Transactions through the New and Send endpoints.
+--------------+---------------------------------
+ version      +  
+--------------+---------------------------------
*/

import java.io.Serializable;
import java.util.List;

public class TxSkeleton implements Serializable {

    private Tx tx;
    private List<String> tosign;
    private List<String> signatures;
    private List<String> pubkeys;
    private List<String> tosign_tx;
    private List<Error> errors;

    class Error {
        private String error;

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }

        @Override
        public String toString() {
            return "Error{" +
                    "error='" + error + '\'' +
                    '}';
        }
    }

    public Tx getTx() {
        return tx;
    }

    public void setTx(Tx tx) {
        this.tx = tx;
    }

    public List<String> getTosign() {
        return tosign;
    }

    public void setTosign(List<String> tosign) {
        this.tosign = tosign;
    }

    public List<String> getSignatures() {
        return signatures;
    }

    public void setSignatures(List<String> signatures) {
        this.signatures = signatures;
    }

    public List<String> getPubkeys() {
        return pubkeys;
    }

    public void setPubkeys(List<String> pubkeys) {
        this.pubkeys = pubkeys;
    }

    public List<String> getTosign_tx() {
        return tosign_tx;
    }

    public void setTosign_tx(List<String> tosign_tx) {
        this.tosign_tx = tosign_tx;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

    @Override
    public String toString() {
        return "TxSkeleton{" +
                "tx=" + tx +
                ", tosign=" + tosign +
                ", signatures=" + signatures +
                ", pubkeys=" + pubkeys +
                ", tosign_tx=" + tosign_tx +
                ", errors=" + errors +
                '}';
    }
}

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
+ description  +   Array of full transaction details associated with this address. Usually only returned from the Address Full Endpoint.
+--------------+---------------------------------
+ version      +  
+--------------+---------------------------------
*/

import java.io.Serializable;
import java.util.List;

/**
 * A TX represents the current state of a particular
 * transaction from either a Block within a Blockchain,
 * or an unconfirmed transaction that has yet to be included in a Block.
 * Typically returned from the Unconfirmed Transactions and Transaction Hash endpoints.
 */
public class Tx implements Serializable {
    private int block_height;
    private String hash;
    private List<String> addresses;
    private int total;
    private int fees;
    private int size;
    private String preference;
    private String relayed_by;
    private String received;
    private int ver;
    private int lock_time;
    private boolean double_spend;
    private int vin_sz;
    private int vout_sz;
    private int confirmations;
    private List<TxInput> inputs;
    private List<TxOutput> outputs;
    private boolean opt_in_rbf;
    private float confidence;
    private String confirmed;
    private int receive_count;
    private String change_address;
    private String block_hash;
    private int block_index;
    private String double_of;
    private String data_protocol;
    private String hex;
    private String next_inputs;
    private String next_outputs;

    public int getBlock_height() {
        return block_height;
    }

    public void setBlock_height(int block_height) {
        this.block_height = block_height;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public List<String> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<String> addresses) {
        this.addresses = addresses;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getFees() {
        return fees;
    }

    public void setFees(int fees) {
        this.fees = fees;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }

    public String getRelayed_by() {
        return relayed_by;
    }

    public void setRelayed_by(String relayed_by) {
        this.relayed_by = relayed_by;
    }

    public String getReceived() {
        return received;
    }

    public void setReceived(String received) {
        this.received = received;
    }

    public int getVer() {
        return ver;
    }

    public void setVer(int ver) {
        this.ver = ver;
    }

    public int getLock_time() {
        return lock_time;
    }

    public void setLock_time(int lock_time) {
        this.lock_time = lock_time;
    }

    public boolean isDouble_spend() {
        return double_spend;
    }

    public void setDouble_spend(boolean double_spend) {
        this.double_spend = double_spend;
    }

    public int getVin_sz() {
        return vin_sz;
    }

    public void setVin_sz(int vin_sz) {
        this.vin_sz = vin_sz;
    }

    public int getVout_sz() {
        return vout_sz;
    }

    public void setVout_sz(int vout_sz) {
        this.vout_sz = vout_sz;
    }

    public int getConfirmations() {
        return confirmations;
    }

    public void setConfirmations(int confirmations) {
        this.confirmations = confirmations;
    }

    public List<TxInput> getInputs() {
        return inputs;
    }

    public void setInputs(List<TxInput> inputs) {
        this.inputs = inputs;
    }

    public List<TxOutput> getOutputs() {
        return outputs;
    }

    public void setOutputs(List<TxOutput> outputs) {
        this.outputs = outputs;
    }

    public boolean isOpt_in_rbf() {
        return opt_in_rbf;
    }

    public void setOpt_in_rbf(boolean opt_in_rbf) {
        this.opt_in_rbf = opt_in_rbf;
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

    public int getReceive_count() {
        return receive_count;
    }

    public void setReceive_count(int receive_count) {
        this.receive_count = receive_count;
    }

    public String getChange_address() {
        return change_address;
    }

    public void setChange_address(String change_address) {
        this.change_address = change_address;
    }

    public String getBlock_hash() {
        return block_hash;
    }

    public void setBlock_hash(String block_hash) {
        this.block_hash = block_hash;
    }

    public int getBlock_index() {
        return block_index;
    }

    public void setBlock_index(int block_index) {
        this.block_index = block_index;
    }

    public String getDouble_of() {
        return double_of;
    }

    public void setDouble_of(String double_of) {
        this.double_of = double_of;
    }

    public String getData_protocol() {
        return data_protocol;
    }

    public void setData_protocol(String data_protocol) {
        this.data_protocol = data_protocol;
    }

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }

    public String getNext_inputs() {
        return next_inputs;
    }

    public void setNext_inputs(String next_inputs) {
        this.next_inputs = next_inputs;
    }

    public String getNext_outputs() {
        return next_outputs;
    }

    public void setNext_outputs(String next_outputs) {
        this.next_outputs = next_outputs;
    }

    @Override
    public String toString() {
        return "Tx{" +
                "block_height=" + block_height +
                ", hash='" + hash + '\'' +
                ", addresses=" + addresses +
                ", total=" + total +
                ", fees=" + fees +
                ", size=" + size +
                ", preference='" + preference + '\'' +
                ", relayed_by='" + relayed_by + '\'' +
                ", received='" + received + '\'' +
                ", ver=" + ver +
                ", lock_time=" + lock_time +
                ", double_spend=" + double_spend +
                ", vin_sz=" + vin_sz +
                ", vout_sz=" + vout_sz +
                ", confirmations=" + confirmations +
                ", inputs=" + inputs +
                ", outputs=" + outputs +
                ", opt_in_rbf=" + opt_in_rbf +
                ", confidence=" + confidence +
                ", confirmed='" + confirmed + '\'' +
                ", receive_count=" + receive_count +
                ", change_address='" + change_address + '\'' +
                ", block_hash='" + block_hash + '\'' +
                ", block_index=" + block_index +
                ", double_of='" + double_of + '\'' +
                ", data_protocol='" + data_protocol + '\'' +
                ", hex='" + hex + '\'' +
                ", next_inputs='" + next_inputs + '\'' +
                ", next_outputs='" + next_outputs + '\'' +
                '}';
    }
}

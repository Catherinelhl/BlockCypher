package bcaasc.io.btcdemo.bean;
/*
+--------------+---------------------------------
+ author       +   Catherine Liu
+--------------+---------------------------------
+ since        +   2019/3/12 17:37
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

public class Wallet implements Serializable {
    private String token;
    private String name;
    private List<String> addresses;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<String> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "token='" + token + '\'' +
                ", name='" + name + '\'' +
                ", addresses=" + addresses +
                '}';
    }
}

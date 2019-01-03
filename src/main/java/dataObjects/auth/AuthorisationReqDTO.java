package dataObjects.auth;

import java.util.Map;

public class AuthorisationReqDTO {

    private String emailAddress;
    private String networkId;
    private String password;
    private String audience;
    private String requireBank;
    private String userName;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getNetworkId() {
        return networkId;
    }

    public void setNetworkId(String networkId) {
        this.networkId = networkId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }

    public String getRequireBank() {
        return requireBank;
    }

    public void setRequireBank(String requireBank) {
        this.requireBank = requireBank;
    }



}

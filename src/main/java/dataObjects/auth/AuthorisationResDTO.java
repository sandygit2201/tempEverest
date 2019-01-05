package dataObjects.auth;

import java.util.List;

public class AuthorisationResDTO {


    private String token;
    private String idToken;
    private String memberId;
    private String networkId;
    private List<ChallengeDTO> challenges;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getIdToken() {
        return idToken;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getNetworkId() {
        return networkId;
    }

    public void setNetworkId(String networkId) {
        this.networkId = networkId;
    }

    public List<ChallengeDTO> getChallenges() {
        return challenges;
    }

    public void setChallenges(List<ChallengeDTO> challenges) {
        this.challenges = challenges;
    }
}

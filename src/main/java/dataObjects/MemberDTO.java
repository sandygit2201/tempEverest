package dataObjects;

import dataObjects.shifts.ClassificationDTO;

public class MemberDTO {

    private int id;
    private String firstName;
    private String lastName;
    private int networkId;
    private String isAdmin;
    private ClassificationDTO classification;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getNetworkId() {
        return networkId;
    }

    public void setNetworkId(int networkId) {
        this.networkId = networkId;
    }

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    public ClassificationDTO getClassification() {
        return classification;
    }

    public void setClassification(ClassificationDTO classification) {
        this.classification = classification;
    }
}

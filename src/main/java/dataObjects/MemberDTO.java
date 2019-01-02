package dataObjects;

import dataObjects.shifts.ClassificationDTO;

public class MemberDTO {

    private int id;
    private String firstName;
    private String lastName;
    private int networkId;
    private boolean isAdmin;
    private ClassificationDTO classificationDTO;

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

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public ClassificationDTO getClassificationDTO() {
        return classificationDTO;
    }

    public void setClassificationDTO(ClassificationDTO classificationDTO) {
        this.classificationDTO = classificationDTO;
    }
}

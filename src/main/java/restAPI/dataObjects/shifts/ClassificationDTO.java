package restAPI.dataObjects.shifts;

public class ClassificationDTO {

    private int id;
    private String name;
    private int level;
    private int awardId;
    private String isSalaried;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getAwardId() {
        return awardId;
    }

    public void setAwardId(int awardId) {
        this.awardId = awardId;
    }

    public String getIsSalaried() {
        return isSalaried;
    }

    public void setIsSalaried(String isSalaried) {
        this.isSalaried = isSalaried;
    }
}

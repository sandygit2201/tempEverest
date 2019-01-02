package dataObjects.shifts;

import dataObjects.MemberDTO;

public class ShiftsResDTO {

    private int id;
    private String rosterId;
    private ShiftPositionDTO shiftPosition;
    private String startTime;
    private String endTime;
    private SubLocationDTO subLocation;
    private ClassificationDTO classification;
    private String totalHours;
    private float totalPay;
    private int overtimeHours;
    private MemberDTO member;
    private String subShifts;
    private String breaks;

    public String getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(String totalHours) {
        this.totalHours = totalHours;
    }

    public float getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(float totalPay) {
        this.totalPay = totalPay;
    }

    public int getOvertimeHours() {
        return overtimeHours;
    }

    public void setOvertimeHours(int overtimeHours) {
        this.overtimeHours = overtimeHours;
    }

    public MemberDTO getMember() {
        return member;
    }

    public void setMember(MemberDTO memberDTO) {
        this.member = memberDTO;
    }

    public String getSubShifts() {
        return subShifts;
    }

    public void setSubShifts(String subShifts) {
        this.subShifts = subShifts;
    }

    public String getBreaks() {
        return breaks;
    }

    public void setBreaks(String breaks) {
        this.breaks = breaks;
    }

    public ClassificationDTO getClassification() {
        return classification;
    }

    public void setClassification(ClassificationDTO classificationDTO) {
        this.classification = classificationDTO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRosterId() {
        return rosterId;
    }

    public void setRosterId(String rosterId) {
        this.rosterId = rosterId;
    }

    public ShiftPositionDTO getShiftPosition() {
        return shiftPosition;
    }

    public void setShiftPosition(ShiftPositionDTO shiftPositionDTO) {
        this.shiftPosition = shiftPositionDTO;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public SubLocationDTO getSubLocation() {
        return subLocation;
    }

    public void setSubLocation(SubLocationDTO subLocationDTO) {
        this.subLocation = subLocationDTO;
    }
}

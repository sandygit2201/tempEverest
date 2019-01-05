package dataObjects.shifts;

import dataObjects.MemberDTO;

import java.util.ArrayList;

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
    private int status;
    private ArrayList<SubShiftDTO> subShifts;
    private ArrayList<BreakDTO> breaks;

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

    public void setShiftPosition(ShiftPositionDTO shiftPosition) {
        this.shiftPosition = shiftPosition;
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

    public void setSubLocation(SubLocationDTO subLocation) {
        this.subLocation = subLocation;
    }

    public ClassificationDTO getClassification() {
        return classification;
    }

    public void setClassification(ClassificationDTO classification) {
        this.classification = classification;
    }

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

    public void setMember(MemberDTO member) {
        this.member = member;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ArrayList<SubShiftDTO> getSubShifts() {
        return subShifts;
    }

    public void setSubShifts(ArrayList<SubShiftDTO> subShifts) {
        this.subShifts = subShifts;
    }

    public ArrayList<BreakDTO> getBreaks() {
        return breaks;
    }

    public void setBreaks(ArrayList<BreakDTO> breaks) {
        this.breaks = breaks;
    }
}

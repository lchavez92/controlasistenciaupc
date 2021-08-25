package pe.upc.controlasistencias.ui.leaves.model;

import java.util.Date;

public class LeaveListItem {
    private String title;

    private String type;

    private Date startDate;

    private Date endDate;

    private String managerName;

    private LeaveStatus status;

    private String note;

    public LeaveListItem(String title, String type, Date startDate, Date endDate, String managerName, LeaveStatus status, String note) {
        this.title = title;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
        this.managerName = managerName;
        this.status = status;
        this.note = note;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public LeaveStatus getStatus() {
        return status;
    }

    public void setStatus(LeaveStatus status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}

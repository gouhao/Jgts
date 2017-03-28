package com.xdja.jwt.jgts.bean;

/**
 * Created by gouhao on 3/28/2017.
 */

public class QueryEvent {
    private String session;
    private String eventId;
    private String policeId;
    private String statusId;
    private String classId;
    private String typeId;
    private String detailId;
    private String levelId;
    private String callTimeStart;
    private String callTimeEnd;

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getPoliceId() {
        return policeId;
    }

    public void setPoliceId(String policeId) {
        this.policeId = policeId;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getDetailId() {
        return detailId;
    }

    public void setDetailId(String detailId) {
        this.detailId = detailId;
    }

    public String getLevelId() {
        return levelId;
    }

    public void setLevelId(String levelId) {
        this.levelId = levelId;
    }

    public String getCallTimeStart() {
        return callTimeStart;
    }

    public void setCallTimeStart(String callTimeStart) {
        this.callTimeStart = callTimeStart;
    }

    public String getCallTimeEnd() {
        return callTimeEnd;
    }

    public void setCallTimeEnd(String callTimeEnd) {
        this.callTimeEnd = callTimeEnd;
    }
}

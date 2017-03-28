package com.xdja.jwt.jgts.bean;

/**
 * Created by gouhao on 3/28/2017.
 */

public class PoliceDealStatus {
    private String session;
    private String eventId;
    private String policeId;

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
}

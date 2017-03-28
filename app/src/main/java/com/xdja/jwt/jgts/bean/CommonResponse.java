package com.xdja.jwt.jgts.bean;

/**
 * Created by gouhao on 3/28/2017.
 */

public class CommonResponse extends Response {
    private String session;
    private String eventId;

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getSession() {

        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }
}

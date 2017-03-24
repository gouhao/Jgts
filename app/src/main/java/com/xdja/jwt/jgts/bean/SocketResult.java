package com.xdja.jwt.jgts.bean;

/**
 * Created by gouhao on 3/24/2017.
 */

public class SocketResult {
    private int appcode;
    private String databuffer;
    private int resultlist;

    public int getAppcode() {
        return appcode;
    }

    public void setAppcode(int appcode) {
        this.appcode = appcode;
    }

    public String getDatabuffer() {
        return databuffer;
    }

    public void setDatabuffer(String databuffer) {
        this.databuffer = databuffer;
    }

    public int getResultlist() {
        return resultlist;
    }

    public void setResultlist(int resultlist) {
        this.resultlist = resultlist;
    }
}

package com.xdja.jwt.jgts.bean;

import java.util.List;

/**
 * Created by gouhao on 3/28/2017.
 */

public class QueryResponse extends Response {
    private List<Event> resultlist;

    public List<Event> getResultlist() {
        return resultlist;
    }

    public void setResultlist(List<Event> resultlist) {
        this.resultlist = resultlist;
    }
}

package com.xdja.jwt.jgts.bean;

import com.xdja.jwt.jgts.utils.xml.XmlField;

/**
 * Created by gouhao on 3/24/2017.
 */

public class SocketResult {
    private int appcode;

    @XmlField(name = "databuffer")
    private String dataBuffer;

    @XmlField(name = "resultlist")
    private int resultList;

    public int getAppCode() {
        return appcode;
    }

    public void setAppCode(int appCode) {
        this.appcode = appCode;
    }

    public String getDataBuffer() {
        return dataBuffer;
    }

    public void setDataBuffer(String dataBuffer) {
        this.dataBuffer = dataBuffer;
    }

    public int getResultList() {
        return resultList;
    }

    public void setResultList(int resultList) {
        this.resultList = resultList;
    }
}

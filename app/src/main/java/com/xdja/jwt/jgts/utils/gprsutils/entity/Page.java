package com.xdja.jwt.jgts.utils.gprsutils.entity;


public class Page {

    private int size;
    private int totalLen;
    private int currentLen;
    private int totalPage;
    private int beginNo;
    private String sourceCondition;
    private String sourceDbSource;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotalLen() {
        return totalLen;
    }

    public void setTotalLen(int totalLen) {
        this.totalLen = totalLen;
    }

    public int getCurrentLen() {
        return currentLen;
    }

    public void setCurrentLen(int currentLen) {
        this.currentLen = currentLen;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getBeginNo() {
        return beginNo;
    }

    public void setBeginNo(int beginNo) {
        this.beginNo = beginNo;
    }

    public String getSourceCondition() {
        return sourceCondition;
    }

    public void setSourceCondition(String sourceCondition) {
        this.sourceCondition = sourceCondition;
    }

    public String getSourceDbSource() {
        return sourceDbSource;
    }

    public void setSourceDbSource(String sourceDbSource) {
        this.sourceDbSource = sourceDbSource;
    }
}

package com.xdja.jwt.jgts.bean;

import com.xdja.jwt.jgts.utils.xml.XmlField;

import java.util.List;

/**
 * Created by gouhao on 3/27/2017.
 */

public class LoginRequest {
    private int system;

    private String version;

    private String username;

    private String password;

    private List<TestBean> testBeanList;

    public List<TestBean> getTestBeanList() {
        return testBeanList;
    }

    public void setTestBeanList(List<TestBean> testBeanList) {
        this.testBeanList = testBeanList;
    }

    public int getSystem() {
        return system;
    }

    public void setSystem(int system) {
        this.system = system;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

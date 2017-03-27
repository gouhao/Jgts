package com.xdja.jwt.jgts.bean;

import com.xdja.jwt.jgts.utils.xml.XmlField;

/**
 * Created by gouhao on 3/27/2017.
 */

public class LoginRequest {
    @XmlField(name = "sys")
    private int system;

    @XmlField(name = "ver")
    private String version;

    @XmlField(name = "user")
    private String username;

    @XmlField(name = "pwd")
    private String password;

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

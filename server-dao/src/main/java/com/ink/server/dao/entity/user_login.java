package com.ink.server.common.model.entity;

public class user_login {
    private Integer id;

    private String userId;

    private String loginType;

    private String password;

    private String loginIp;

    private String loginTime;

    public user_login() {
    }

    public user_login(Integer id, String userId, String loginType, String password, String loginIp, String loginTime) {
        this.id = id;
        this.userId = userId;
        this.loginType = loginType;
        this.password = password;
        this.loginIp = loginIp;
        this.loginTime = loginTime;
    }

    @Override
    public String toString() {
        return "User_login{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", loginType='" + loginType + '\'' +
                ", password='" + password + '\'' +
                ", loginIp='" + loginIp + '\'' +
                ", loginTime='" + loginTime + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserid() {
        return userId;
    }

    public void setUserid(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getLogintype() {
        return loginType;
    }

    public void setLogintype(String loginType) {
        this.loginType = loginType == null ? null : loginType.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getLoginip() {
        return loginIp;
    }

    public void setLoginip(String loginip) {
        this.loginTime = loginip == null ? null : loginip.trim();
    }

    public String getLogintime() {
        return loginTime;
    }

    public void setLogintime(String logintime) {
        this.loginTime = logintime == null ? null : logintime.trim();
    }
}
package com.ink.entity;

public class User_login {
    private Integer id;

    private String userid;

    private String logintype;

    private String password;

    private String loginip;

    private String logintime;

    public User_login() {
    }

    public User_login(Integer id, String userid, String logintype, String password, String loginip, String logintime) {
        this.id = id;
        this.userid = userid;
        this.logintype = logintype;
        this.password = password;
        this.loginip = loginip;
        this.logintime = logintime;
    }

    @Override
    public String toString() {
        return "User_login{" +
                "id=" + id +
                ", userid='" + userid + '\'' +
                ", logintype='" + logintype + '\'' +
                ", password='" + password + '\'' +
                ", loginip='" + loginip + '\'' +
                ", logintime='" + logintime + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getLogintype() {
        return logintype;
    }

    public void setLogintype(String logintype) {
        this.logintype = logintype == null ? null : logintype.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getLoginip() {
        return loginip;
    }

    public void setLoginip(String loginip) {
        this.loginip = loginip == null ? null : loginip.trim();
    }

    public String getLogintime() {
        return logintime;
    }

    public void setLogintime(String logintime) {
        this.logintime = logintime == null ? null : logintime.trim();
    }
}
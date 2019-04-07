package com.ink.entity.login;

/**
 * @author Created by carlos
 */
public class UserEntity {
    String username;
    String logintype;
    String password;

    public UserEntity(String username, String logintype, String password) {
        this.username = username;
        this.logintype = logintype;
        this.password = password;
    }

    public UserEntity() {
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "username='" + username + '\'' +
                ", logintype='" + logintype + '\'' +
                ", password='" + password + '\'' +
                '}';
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

    public String getLogintype() {
        return logintype;
    }

    public void setLogintype(String logintype) {
        this.logintype = logintype;
    }
}

package com.ink.entity.login;

/**
 * @author Created by carlos
 */
public class userEntity {
    String userName;
    String loginType;
    String password;

    public userEntity(String userName, String loginType, String password) {
        this.userName = userName;
        this.loginType = loginType;
        this.password = password;
    }

    public userEntity() {
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userName='" + userName + '\'' +
                ", loginType='" + loginType + '\'' +
                ", password='" + password + '\'' +
                '}';
    }



    public String getUsername() {
        return userName;
    }

    public void setUsername(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogintype() {
        return loginType;
    }

    public void setLogintype(String loginType) {
        this.loginType = loginType;
    }
}

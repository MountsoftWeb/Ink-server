package com.ink.model.entity.login;

/**
 * @author Created by carlos
 */
public class userEntity {
    String phone;
    String loginType;
    String password;

    public userEntity(String phone, String loginType, String password) {
        this.phone = phone;
        this.loginType = loginType;
        this.password = password;
    }

    public userEntity() {
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "phone='" + phone + '\'' +
                ", loginType='" + loginType + '\'' +
                ", password='" + password + '\'' +
                '}';
    }



    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

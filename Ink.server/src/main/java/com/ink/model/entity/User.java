package com.ink.model.entity;

import java.util.Date;

public class User {
    private Integer id;

    private String userName;

    private String profile;

    private String sex;

    private String picture;

    private String registTime;

    private String major;

    private String phone;

    private user_login user_login;

    public User() {
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User(Integer id, String userName, String profile, String sex, String picture, String registTime,
            String major) {
        this.id = id;
        this.userName = userName;
        this.profile = profile;
        this.sex = sex;
        this.picture = picture;
        this.registTime = registTime;
        this.major = major;
    }

    public User(String userName, String picture){
        this.userName = userName;
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", profile='" + profile + '\'' +
                ", sex='" + sex + '\'' +
                ", picture='" + picture + '\'' +
                ", registTime='" + registTime + '\'' +
                ", major='" + major + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile == null ? null : profile.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public String getRegisttime() {
        return registTime;
    }

    public void setRegisttime(String registTime) {
        this.registTime = registTime == null ? null : registTime.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    public user_login getUser_login() {
        return user_login;
    }

    public void setUser_login(user_login user_login) {
        this.user_login = user_login;
    }

	public void setRegisttime(Date date) {
	}

}
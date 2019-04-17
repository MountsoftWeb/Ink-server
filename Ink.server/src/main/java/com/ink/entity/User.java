package com.ink.entity;

public class User {
    private Integer id;

    private String username;

    private String profile;

    private String sex;

    private String avatar;

    private String registtime;

    private String school;

    private String major;

    private User_login user_login;


    public User() {
    }

    public User(Integer id, String username, String profile, String sex, String avatar, String registtime, String school, String major) {
        this.id = id;
        this.username = username;
        this.profile = profile;
        this.sex = sex;
        this.avatar = avatar;
        this.registtime = registtime;
        this.school = school;
        this.major = major;
    }

    public User(String username, String avatar){
        this.username = username;
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", profile='" + profile + '\'' +
                ", sex='" + sex + '\'' +
                ", avatar='" + avatar + '\'' +
                ", registtime='" + registtime + '\'' +
                ", school='" + school + '\'' +
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
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public String getRegisttime() {
        return registtime;
    }

    public void setRegisttime(String registtime) {
        this.registtime = registtime == null ? null : registtime.trim();
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    public User_login getUser_login() {
        return user_login;
    }

    public void setUser_login(User_login user_login) {
        this.user_login = user_login;
    }

}
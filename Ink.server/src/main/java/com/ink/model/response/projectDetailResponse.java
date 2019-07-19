package com.ink.model.response;


public class projectDetailResponse {
    private Integer id;
    private String name;
    private String upDate;
    private String projectPicture;
    private Integer apprecations;
    private String userName;
    private String userPicture;
    private String profile;
    private String major;
    private String fans;

    public Integer getId() {
        return id;
    }

    public String getUserPicture() {
        return userPicture;
    }

    public void setUserPicture(String userPicture) {
        this.userPicture = userPicture;
    }

    public String getProjectPicture() {
        return projectPicture;
    }

    public void setProjectPicture(String projectPicture) {
        this.projectPicture = projectPicture;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getFans() {
        return fans;
    }

    public void setFans(String fans) {
        this.fans = fans;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getApprecations() {
        return apprecations;
    }

    public void setApprecations(Integer apprecations) {
        this.apprecations = apprecations;
    }


    public String getUpDate() {
        return upDate;
    }

    public void setUpDate(String upDate) {
        this.upDate = upDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
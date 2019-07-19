package com.ink.model.response;

/**
 * @author Created by carlos
 */
public class projectResponse {
    private Integer id;
    private String name;
    private String upDate;
    private String picture;
    private Integer apprecations;
    private Integer collections;
    private String userName;

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUpDate() {
        return upDate;
    }

    public void setUpDate(String upDate) {
        this.upDate = upDate;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getApprecations() {
        return apprecations;
    }

    public void setApprecations(Integer apprecations) {
        this.apprecations = apprecations;
    }

    public Integer getCollections() {
        return collections;
    }

    public void setCollections(Integer collections) {
        this.collections = collections;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
//    p.name, p.up_date, p.picture, p.apprecations, p.collections
//             , u.user_name
}

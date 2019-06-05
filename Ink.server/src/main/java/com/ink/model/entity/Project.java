package com.ink.model.entity;

public class Project {
    private Integer id;
    private Integer userId;
    private Double price;
    private String name;
    private String picture;
    private String upDate;
    private String deleteDate;
    private Integer categoryId;
    private Integer apprecations;
    private Integer collections;
    private project_category project_category;



    public Project() {

    }

    public Project(Integer id, String name, String upDate, Integer apprecations, Integer collections) {
        this.id = id;
        this.name = name;
        this.upDate = upDate;
        this.apprecations = apprecations;
        this.collections = collections;
    }

    public String getUpDate() {
        return upDate;
    }

    public void setUpDate(String upDate) {
        this.upDate = upDate;
    }

    public String getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(String deleteDate) {
        this.deleteDate = deleteDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public com.ink.model.entity.project_category getProject_category() {
        return project_category;
    }

    public void setProject_category(com.ink.model.entity.project_category project_category) {
        this.project_category = project_category;
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
}
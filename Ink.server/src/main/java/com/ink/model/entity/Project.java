package com.ink.model.entity;

public class Project {
    private Integer id;
    private Integer userId;
    private String name;
    private Integer paintingwayId;
    private Integer categoryId;
    private Integer labelId;
    private Integer locationId;
    private String upDate;
    private String deleteDate;
    private String picture;
    private Integer apprecations;
    private Integer collections;
    private project_category project_category;
    private String describe;

    public Project() {
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Project(Integer id, Integer userId, String name, Integer paintingwayId, Integer categoryId, Integer labelId,
            Integer locationId, String upDate, String deleteDate, String picture, Integer apprecations,
            Integer collections, com.ink.model.entity.project_category project_category) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.paintingwayId = paintingwayId;
        this.categoryId = categoryId;
        this.labelId = labelId;
        this.locationId = locationId;
        this.upDate = upDate;
        this.deleteDate = deleteDate;
        this.picture = picture;
        this.apprecations = apprecations;
        this.collections = collections;
        this.project_category = project_category;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPaintingwayId() {
        return paintingwayId;
    }

    public void setPaintingwayId(Integer paintingwayId) {
        this.paintingwayId = paintingwayId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getLabelId() {
        return labelId;
    }

    public void setLabelId(Integer labelId) {
        this.labelId = labelId;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
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

    public com.ink.model.entity.project_category getProject_category() {
        return project_category;
    }

    public void setProject_category(com.ink.model.entity.project_category project_category) {
        this.project_category = project_category;
    }
}
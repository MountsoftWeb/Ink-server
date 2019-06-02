package com.ink.entity;

public class Project {
    private Integer id;
    private String userName;
    private Double price;
    private String name;
    private String picture;
    private Integer categoryId;
    private project_category project_category;

    public Project() {

    }
    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", picture='" + picture + '\'' +
                ", categoryId=" + categoryId +
                ", project_category=" + project_category +
                '}';
    }

    public Project(Integer id, String userName, Double price, String name, String picture, Integer categoryId, com.ink.entity.project_category project_category) {
        this.id = id;
        this.userName = userName;
        this.price = price;
        this.name = name;
        this.picture = picture;
        this.categoryId = categoryId;
        this.project_category = project_category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public com.ink.entity.project_category getProject_category() {
        return project_category;
    }

    public void setProject_category(com.ink.entity.project_category project_category) {
        this.project_category = project_category;
    }
}
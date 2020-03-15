package com.ink.common.model.entity;

/**
 * @author Created by carlos
 */
public class category {
    private Integer id;
    private String categoryName;

    public category(Integer id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }

    public category() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}

package com.ink.server.common.response;

public class categoryResponse {
    private Integer id;
    private String  categoryName;


    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
    public void setCategorylName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

}
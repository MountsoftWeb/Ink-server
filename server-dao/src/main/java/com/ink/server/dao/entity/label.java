package com.ink.server.dao.entity;

/**
 * @author Created by carlos
 */
public class label {
    private Integer id;
    private String labelName;

    public label() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public label(Integer id, String labelName) {
        this.id = id;
        this.labelName = labelName;
    }
}

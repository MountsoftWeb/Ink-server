package com.ink.server.common.model.entity;


public class appreciate {
    private Integer id;
    private Integer projectId;
    private Integer typeId;
    private Integer userId;
    private Integer status;
    private String appreciateTime;
    
    public Integer getId() {
        return id;
    }

    public String getAppreciateTime() {
        return appreciateTime;
    }

    public void setAppreciateTime(String appreciateTime) {
        this.appreciateTime = appreciateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public void setId(Integer id) {
        this.id = id;
    }



}
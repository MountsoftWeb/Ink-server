package com.ink.server.dao.entity;

public class comment {
    private Integer id;
    private Integer projectId;
    private Integer userId;
    private String content;
    private String commentTime;

    public Integer getId() {
        return id;
    }

    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
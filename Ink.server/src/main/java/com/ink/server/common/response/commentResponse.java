package com.ink.server.common.model.response;

public class commentResponse {
    private String username;
    private String picture;
    private String content;
    private String commentTime;

    public String getUsername() {
        return username;
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
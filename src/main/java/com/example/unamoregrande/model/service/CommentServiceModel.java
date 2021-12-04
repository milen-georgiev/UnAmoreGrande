package com.example.unamoregrande.model.service;

public class CommentServiceModel {

    private Long articleId;
    private String description;
    private String user;

    public CommentServiceModel() {
    }

    public Long getArticleId() {
        return articleId;
    }

    public CommentServiceModel setArticleId(Long articleId) {
        this.articleId = articleId;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CommentServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getUser() {
        return user;
    }

    public CommentServiceModel setUser(String user) {
        this.user = user;
        return this;
    }
}

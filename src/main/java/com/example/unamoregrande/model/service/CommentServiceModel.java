package com.example.unamoregrande.model.service;

public class CommentServiceModel {

    private Long articleId;
    private String message;
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
        return message;
    }

    public CommentServiceModel setDescription(String message) {
        this.message = message;
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

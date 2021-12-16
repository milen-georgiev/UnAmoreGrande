package com.example.unamoregrande.model.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class CommentsEntity extends BaseEntity {

    @Size(min = 5)
    @NotNull
    private String message;
    @ManyToOne
    private UserEntity user;
    @ManyToOne
    private GrandmasSecretArticlesEntity articles;
    private String alerts;
    private LocalDateTime added;

    public CommentsEntity() {
    }

    public String getDescription() {
        return message;
    }

    public CommentsEntity setDescription(String message) {
        this.message = message;
        return this;
    }

    public UserEntity getUser() {
        return user;
    }

    public CommentsEntity setUser(UserEntity user) {
        this.user = user;
        return this;
    }

    public GrandmasSecretArticlesEntity getArticles() {
        return articles;
    }

    public CommentsEntity setArticles(GrandmasSecretArticlesEntity articles) {
        this.articles = articles;
        return this;
    }

    public String getAlerts() {
        return alerts;
    }

    public CommentsEntity setAlerts(String alerts) {
        this.alerts = alerts;
        return this;
    }

    public LocalDateTime getAdded() {
        return added;
    }

    public CommentsEntity setAdded(LocalDateTime added) {
        this.added = added;
        return this;
    }
}

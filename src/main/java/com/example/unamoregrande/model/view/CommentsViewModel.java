package com.example.unamoregrande.model.view;


import java.time.LocalDateTime;

public class CommentsViewModel {

    private Long commentId;
    private String description;
    private String user;
    private String alerts;
    private LocalDateTime added;
    private boolean canDelete;

    public CommentsViewModel() {
    }

    public Long getCommentId() {
        return commentId;
    }

    public CommentsViewModel setCommentId(Long commentId) {
        this.commentId = commentId;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CommentsViewModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getUser() {
        return user;
    }

    public CommentsViewModel setUser(String user) {
        this.user = user;
        return this;
    }

    public String getAlerts() {
        return alerts;
    }

    public CommentsViewModel setAlerts(String alerts) {
        this.alerts = alerts;
        return this;
    }

    public LocalDateTime getAdded() {
        return added;
    }

    public CommentsViewModel setAdded(LocalDateTime added) {
        this.added = added;
        return this;
    }

    public boolean isCanDelete() {
        return canDelete;
    }

    public CommentsViewModel setCanDelete(boolean canDelete) {
        this.canDelete = canDelete;
        return this;
    }

}

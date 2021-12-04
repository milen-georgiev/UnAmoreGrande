package com.example.unamoregrande.model.view;

import com.example.unamoregrande.model.entity.CommentsEntity;
import com.example.unamoregrande.model.entity.UserEntity;
import com.example.unamoregrande.model.entity.enums.ArticlesNameEnum;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GrandmasSecretViewModel {

    private Long id;
    private String name;
    private String description;
    private ArticlesNameEnum category;
    private List<CommentsEntity> comments = new ArrayList<>();
    private UserEntity published;
    private String url;
    private String publicId;
    private LocalDate added;

    public GrandmasSecretViewModel() {
    }

    public Long getId() {
        return id;
    }

    public GrandmasSecretViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public GrandmasSecretViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public GrandmasSecretViewModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public ArticlesNameEnum getCategory() {
        return category;
    }

    public GrandmasSecretViewModel setCategory(ArticlesNameEnum category) {
        this.category = category;
        return this;
    }

    public List<CommentsEntity> getComments() {
        return comments;
    }

    public GrandmasSecretViewModel setComments(List<CommentsEntity> comments) {
        this.comments = comments;
        return this;
    }

    public UserEntity getPublished() {
        return published;
    }

    public GrandmasSecretViewModel setPublished(UserEntity published) {
        this.published = published;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public GrandmasSecretViewModel setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getPublicId() {
        return publicId;
    }

    public GrandmasSecretViewModel setPublicId(String publicId) {
        this.publicId = publicId;
        return this;
    }

    public LocalDate getAdded() {
        return added;
    }

    public GrandmasSecretViewModel setAdded(LocalDate added) {
        this.added = added;
        return this;
    }
}

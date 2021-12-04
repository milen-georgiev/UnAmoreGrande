package com.example.unamoregrande.model.entity;

import com.example.unamoregrande.model.entity.enums.ArticlesNameEnum;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "grandmas_secret_articles")
public class GrandmasSecretArticlesEntity extends BaseEntity{

    @Column(nullable = false)
    private String name;
    @Size(min = 50)
    @Column(nullable = false, columnDefinition = "LongText")
    private String description;
    @Enumerated(EnumType.STRING)
    private ArticlesNameEnum category;
    @OneToMany(mappedBy = "articles", fetch = FetchType.LAZY)
    private List<CommentsEntity> comments = new ArrayList<>();
    @ManyToOne
    private UserEntity published;
    private String url;
    private String publicId;
    private LocalDate added;
    private String status;

    public GrandmasSecretArticlesEntity() {
    }

    public String getName() {
        return name;
    }

    public GrandmasSecretArticlesEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public GrandmasSecretArticlesEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public ArticlesNameEnum getCategory() {
        return category;
    }

    public GrandmasSecretArticlesEntity setCategory(ArticlesNameEnum category) {
        this.category = category;
        return this;
    }

    public List<CommentsEntity> getComments() {
        return comments;
    }

    public GrandmasSecretArticlesEntity setComments(List<CommentsEntity> comments) {
        this.comments = comments;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public GrandmasSecretArticlesEntity setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getPublicId() {
        return publicId;
    }

    public GrandmasSecretArticlesEntity setPublicId(String publicId) {
        this.publicId = publicId;
        return this;
    }

    public UserEntity getPublished() {
        return published;
    }

    public GrandmasSecretArticlesEntity setPublished(UserEntity published) {
        this.published = published;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public GrandmasSecretArticlesEntity setStatus(String status) {
        this.status = status;
        return this;
    }

    public LocalDate getAdded() {
        return added;
    }

    public GrandmasSecretArticlesEntity setAdded(LocalDate added) {
        this.added = added;
        return this;
    }
}

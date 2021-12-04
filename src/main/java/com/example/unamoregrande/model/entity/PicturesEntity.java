package com.example.unamoregrande.model.entity;

import com.example.unamoregrande.model.entity.enums.StyleNameEnum;
import com.example.unamoregrande.model.entity.enums.TypeNameEnum;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pictures")
public class PicturesEntity extends BaseEntity{

    @Column(nullable = false)
    private String url;
    @Enumerated(EnumType.STRING)
    private TypeNameEnum categoryType;
    @Enumerated(EnumType.STRING)
    private StyleNameEnum categoryStyle;
    @ManyToOne
    private UserEntity user;
    private String publicId;
    private String publicationStatus;
    private LocalDate added;
    private Integer likes;

    public PicturesEntity() {
    }

    public String getUrl() {
        return url;
    }

    public PicturesEntity setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getPublicId() {
        return publicId;
    }

    public PicturesEntity setPublicId(String publicId) {
        this.publicId = publicId;
        return this;
    }

    public TypeNameEnum getCategoryType() {
        return categoryType;
    }

    public PicturesEntity setCategoryType(TypeNameEnum categoryTypeEntity) {
        this.categoryType = categoryTypeEntity;
        return this;
    }

    public StyleNameEnum getCategoryStyle() {
        return categoryStyle;
    }

    public PicturesEntity setCategoryStyle(StyleNameEnum categoryStyle) {
        this.categoryStyle = categoryStyle;
        return this;
    }

    public UserEntity getUser() {
        return user;
    }

    public PicturesEntity setUser(UserEntity user) {
        this.user = user;
        return this;
    }

    public String getPublicationStatus() {
        return publicationStatus;
    }

    public PicturesEntity setPublicationStatus(String publicationStatus) {
        this.publicationStatus = publicationStatus;
        return this;
    }

    public LocalDate getAdded() {
        return added;
    }

    public PicturesEntity setAdded(LocalDate added) {
        this.added = added;
        return this;
    }

    public Integer getLikes() {
        return likes;
    }

    public PicturesEntity setLikes(Integer likes) {
        this.likes = likes;
        return this;
    }
}

package com.example.unamoregrande.model.view;


import java.time.Instant;

public class PicturesViewModel {

    private Long id;
    private String url;
    private String publicId;
    private Instant added;
    private Integer likes;

    public PicturesViewModel() {
    }

    public Long getId() {
        return id;
    }

    public PicturesViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public PicturesViewModel setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getPublicId() {
        return publicId;
    }

    public PicturesViewModel setPublicId(String publicId) {
        this.publicId = publicId;
        return this;
    }


    public Instant getAdded() {
        return added;
    }

    public PicturesViewModel setAdded(Instant added) {
        this.added = added;
        return this;
    }

    public Integer getLikes() {
        return likes;
    }

    public PicturesViewModel setLikes(Integer likes) {
        this.likes = likes;
        return this;
    }
}

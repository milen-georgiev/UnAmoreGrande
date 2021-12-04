package com.example.unamoregrande.model.binding;

import javax.validation.constraints.Size;

public class VideoBindingModel {

    @Size(min = 11, max = 11)
    private String videoUrl;

    public VideoBindingModel() {
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public VideoBindingModel setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }
}

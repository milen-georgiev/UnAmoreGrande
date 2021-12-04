package com.example.unamoregrande.service;

import com.example.unamoregrande.model.service.VideoServiceModel;
import com.example.unamoregrande.model.view.VideoViewModel;

import java.util.List;

public interface VideoService {

    void addVideo(VideoServiceModel videoServiceModel, String username);

    List<VideoViewModel> viewVideo();
}

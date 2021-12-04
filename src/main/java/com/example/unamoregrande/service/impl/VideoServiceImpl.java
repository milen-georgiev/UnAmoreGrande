package com.example.unamoregrande.service.impl;

import com.example.unamoregrande.model.entity.VideoEntity;
import com.example.unamoregrande.model.service.VideoServiceModel;
import com.example.unamoregrande.model.view.VideoViewModel;
import com.example.unamoregrande.repository.UserRepository;
import com.example.unamoregrande.repository.VideoRepository;
import com.example.unamoregrande.service.VideoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VideoServiceImpl implements VideoService {

    private final VideoRepository videoRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public VideoServiceImpl(VideoRepository videoRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.videoRepository = videoRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addVideo(VideoServiceModel videoServiceModel, String userId) {

        VideoEntity videoEntity = new VideoEntity();

        videoEntity
                .setVideoUrl(videoServiceModel.getVideoUrl())
                .setPublicationStatus("unverified")
                .setAdded(LocalDate.now())
                .setUser(userRepository.findByUsername(userId).orElseThrow());

        videoRepository.save(videoEntity);

    }

    @Override
    public List<VideoViewModel> viewVideo() {

        List<VideoEntity> allVideo = videoRepository.findAll();

        return allVideo
                .stream()
                .map(videoEntity -> modelMapper.map(videoEntity,VideoViewModel.class))
                .collect(Collectors.toList());
    }


}

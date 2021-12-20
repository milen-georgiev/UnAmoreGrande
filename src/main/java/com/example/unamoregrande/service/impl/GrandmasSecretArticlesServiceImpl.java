package com.example.unamoregrande.service.impl;

import com.example.unamoregrande.model.entity.GrandmasSecretArticlesEntity;
import com.example.unamoregrande.model.entity.UserEntity;
import com.example.unamoregrande.model.service.GrandmasSecretArticlesServiceModel;
import com.example.unamoregrande.model.view.GrandmasSecretViewModel;
import com.example.unamoregrande.repository.GrandmasSecretArticlesRepository;
import com.example.unamoregrande.repository.UserRepository;
import com.example.unamoregrande.service.CloudinaryService;
import com.example.unamoregrande.service.GrandmasSecretArticlesService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GrandmasSecretArticlesServiceImpl implements GrandmasSecretArticlesService {

    private final GrandmasSecretArticlesRepository grandmasSecretArticlesRepository;
    private final UserRepository userRepository;
    private final CloudinaryService cloudinaryService;
    private final ModelMapper modelMapper;

    public GrandmasSecretArticlesServiceImpl(GrandmasSecretArticlesRepository grandmasSecretArticlesRepository,
                                             UserRepository userRepository, CloudinaryService cloudinaryService,
                                             ModelMapper modelMapper) {
        this.grandmasSecretArticlesRepository = grandmasSecretArticlesRepository;
        this.userRepository = userRepository;
        this.cloudinaryService = cloudinaryService;
        this.modelMapper = modelMapper;
    }


    @Override
    public void addGrandmasSecret(GrandmasSecretArticlesServiceModel grandmasSecretArticlesServiceModel, String userId) throws IOException {
        final CloudinaryImage uploaded = this.
                cloudinaryService.
                upload(grandmasSecretArticlesServiceModel.getPictures());

        GrandmasSecretArticlesEntity grandmasEntity = new GrandmasSecretArticlesEntity();

        grandmasEntity
                .setName(grandmasSecretArticlesServiceModel.getName())
                .setDescription(grandmasSecretArticlesServiceModel.getDescription())
                .setCategory(grandmasSecretArticlesServiceModel.getCategory())
                .setPublished(userRepository.findByUsername(userId).orElseThrow())
                .setUrl(uploaded.getUrl())
                .setPublicId(uploaded.getPublicId())
                .setAdded(LocalDate.now())
                .setStatus("unverified");


        grandmasSecretArticlesRepository.save(grandmasEntity);
    }

    @Transactional
    @Override
    public List<GrandmasSecretViewModel> grandmasSecretView() {



        return grandmasSecretArticlesRepository
                .findAll()
                .stream()
                .map(grandmasSecretArticlesEntity -> {
                    GrandmasSecretViewModel grandmasSecretViewModel = modelMapper
                            .map(grandmasSecretArticlesEntity, GrandmasSecretViewModel.class);

                    return grandmasSecretViewModel;
                })
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public GrandmasSecretViewModel findArticlesById(Long id) {

        return grandmasSecretArticlesRepository
                .findById(id)
                .map(grandmasSecretArticlesEntity -> modelMapper.map(grandmasSecretArticlesEntity, GrandmasSecretViewModel.class))
                .orElse(null);

    }

    @Override
    public List<GrandmasSecretViewModel> onlyArticlesUser(String username) {

        UserEntity user = userRepository.findByUsername(username).orElseThrow();

        List<GrandmasSecretArticlesEntity> grandmasSecretArticlesEntities = grandmasSecretArticlesRepository
                .findGrandmasSecretArticlesEntityByPublished(user);

        return grandmasSecretArticlesEntities
                .stream()
                .map(grandmasSecretArticlesEntity -> modelMapper.map(grandmasSecretArticlesEntities, GrandmasSecretViewModel.class))
                .collect(Collectors.toList());
    }
}

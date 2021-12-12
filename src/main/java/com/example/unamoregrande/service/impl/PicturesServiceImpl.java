package com.example.unamoregrande.service.impl;

import com.example.unamoregrande.model.entity.PicturesEntity;
import com.example.unamoregrande.model.entity.enums.StyleNameEnum;
import com.example.unamoregrande.model.entity.enums.TypeNameEnum;
import com.example.unamoregrande.model.service.PicturesServiceModel;
import com.example.unamoregrande.model.view.PicturesViewModel;
import com.example.unamoregrande.repository.PicturesRepository;
import com.example.unamoregrande.repository.UserRepository;
import com.example.unamoregrande.service.CloudinaryService;
import com.example.unamoregrande.service.PicturesService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PicturesServiceImpl implements PicturesService {

    private final PicturesRepository picturesRepository;
    private final UserRepository userRepository;
    private final CloudinaryService cloudinaryService;
    private final ModelMapper modelMapper;

    public PicturesServiceImpl(PicturesRepository picturesRepository, UserRepository userRepository, CloudinaryService cloudinaryService, ModelMapper modelMapper) {
        this.picturesRepository = picturesRepository;
        this.userRepository = userRepository;
        this.cloudinaryService = cloudinaryService;
        this.modelMapper = modelMapper;
    }

    // Cloudinary  ------------------------------
    //-------------------------------------------

    @Override
    public void uploadPictures(PicturesServiceModel picturesServiceModel, String userId) throws IOException {
        PicturesEntity pictures = createPicturesEntity(picturesServiceModel.getPictures());

        pictures
                .setCategoryType(picturesServiceModel.getTypeNameEnum())
                .setCategoryStyle(picturesServiceModel.getStyleNameEnum())
                .setUser(userRepository.findByUsername(userId).orElseThrow())
                .setPublicationStatus("unverified")
                .setAdded(LocalDate.now())
                .setLikes(0);

        picturesRepository.save(pictures);
    }

    private PicturesEntity createPicturesEntity(MultipartFile file) throws IOException {
        final CloudinaryImage uploaded = this.cloudinaryService.upload(file);

        return new PicturesEntity()
                .setPublicId(uploaded.getPublicId())
                .setUrl(uploaded.getUrl());
    }


    // Hairstyles page --------------------------
    //-------------------------------------------

    public List<PicturesViewModel> allPicturesViewHairstyles() {

        List<PicturesEntity> picturesEntityList = picturesRepository
                .findPicturesEntityByCategoryType(TypeNameEnum.HAIRSTYLES);

        return picturesEntityList
                .stream()
                .map(picturesEntity -> modelMapper.map(picturesEntity, PicturesViewModel.class))
                .collect(Collectors.toList());

    }

    @Override
    public List<PicturesViewModel> filterPicturesViewHairstyles(StyleNameEnum styleNameEnum) {

        List<PicturesEntity> picturesEntityList = picturesRepository
                .findPicturesEntityByCategoryTypeAndCategoryStyle(TypeNameEnum.HAIRSTYLES, styleNameEnum);

        return picturesEntityList
                .stream()
                .map(picturesEntity -> modelMapper.map(picturesEntity, PicturesViewModel.class))
                .collect(Collectors.toList());
    }

    // MakeUp page ------------------------------
    //-------------------------------------------

    @Override
    public List<PicturesViewModel> allPicturesViewMakeup() {

        List<PicturesEntity> picturesEntityList = picturesRepository
                .findPicturesEntityByCategoryType(TypeNameEnum.MAKEUP);

        return picturesEntityList
                .stream()
                .map(picturesEntity -> modelMapper.map(picturesEntity, PicturesViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PicturesViewModel> filterPicturesViewMakeup(StyleNameEnum styleNameEnum) {

        List<PicturesEntity> picturesEntityList = picturesRepository
                .findPicturesEntityByCategoryTypeAndCategoryStyle(TypeNameEnum.MAKEUP, styleNameEnum);

        return picturesEntityList
                .stream()
                .map(picturesEntity -> modelMapper.map(picturesEntity, PicturesViewModel.class))
                .collect(Collectors.toList());
    }


    // Manicure page ----------------------------
    //-------------------------------------------


    @Override
    public List<PicturesViewModel> allPicturesViewManicure() {

        List<PicturesEntity> picturesEntityList = picturesRepository
                .findPicturesEntityByCategoryType(TypeNameEnum.MANICURE);

        return picturesEntityList
                .stream()
                .map(picturesEntity -> modelMapper.map(picturesEntity, PicturesViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PicturesViewModel> filterPicturesViewManicure(StyleNameEnum styleNameEnum) {

        List<PicturesEntity> picturesEntityList = picturesRepository
                .findPicturesEntityByCategoryTypeAndCategoryStyle(TypeNameEnum.MANICURE, styleNameEnum);

        return picturesEntityList
                .stream()
                .map(picturesEntity -> modelMapper.map(picturesEntity, PicturesViewModel.class))
                .collect(Collectors.toList());
    }

    // like pictures ----------------------------
    //-------------------------------------------


    @Override
    public void likePictures(Long id) {
         Optional<PicturesEntity> pictures = picturesRepository.findById(id);
         pictures.get().setLikes(pictures.get().getLikes()+1);
         picturesRepository.save(pictures.get());
    }

    @Override
    public void deletePictures(String publicId) {
        picturesRepository.deleteAllByPublicId(publicId);
    }


}

package com.example.unamoregrande.service;

import com.example.unamoregrande.model.entity.enums.StyleNameEnum;
import com.example.unamoregrande.model.service.PicturesServiceModel;
import com.example.unamoregrande.model.view.PicturesViewModel;

import java.io.IOException;
import java.util.List;

public interface PicturesService {

    void uploadPictures(PicturesServiceModel picturesServiceModel, String user) throws IOException;

    List<PicturesViewModel> allPicturesViewHairstyles();

    List<PicturesViewModel> filterPicturesViewHairstyles(StyleNameEnum categoryStyle);

    List<PicturesViewModel> allPicturesViewMakeup();

    List<PicturesViewModel> filterPicturesViewMakeup(StyleNameEnum categoryStyle);

    List<PicturesViewModel> allPicturesViewManicure();

    List<PicturesViewModel> filterPicturesViewManicure(StyleNameEnum categoryStyle);

    void likePictures(Long id);

    void deletePictures(String publicId);


}

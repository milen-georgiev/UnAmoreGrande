package com.example.unamoregrande.model.service;

import com.example.unamoregrande.model.entity.enums.StyleNameEnum;
import com.example.unamoregrande.model.entity.enums.TypeNameEnum;
import org.springframework.web.multipart.MultipartFile;

public class PicturesServiceModel {

    private MultipartFile pictures;
    private TypeNameEnum typeNameEnum;
    private StyleNameEnum styleNameEnum;


    public PicturesServiceModel() {
    }

    public MultipartFile getPictures() {
        return pictures;
    }

    public PicturesServiceModel setPictures(MultipartFile pictures) {
        this.pictures = pictures;
        return this;
    }

    public TypeNameEnum getTypeNameEnum() {
        return typeNameEnum;
    }

    public PicturesServiceModel setTypeNameEnum(TypeNameEnum typeNameEnum) {
        this.typeNameEnum = typeNameEnum;
        return this;
    }

    public StyleNameEnum getStyleNameEnum() {
        return styleNameEnum;
    }

    public PicturesServiceModel setStyleNameEnum(StyleNameEnum styleNameEnum) {
        this.styleNameEnum = styleNameEnum;
        return this;
    }
}

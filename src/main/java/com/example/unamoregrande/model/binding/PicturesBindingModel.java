package com.example.unamoregrande.model.binding;

import com.example.unamoregrande.model.entity.enums.StyleNameEnum;
import com.example.unamoregrande.model.entity.enums.TypeNameEnum;
import org.springframework.web.multipart.MultipartFile;

public class PicturesBindingModel {

    private MultipartFile pictures;
    private TypeNameEnum categoryType;
    private StyleNameEnum categoryStyle;

    public PicturesBindingModel() {
    }

    public MultipartFile getPictures() {
        return pictures;
    }

    public PicturesBindingModel setPictures(MultipartFile pictures) {
        this.pictures = pictures;
        return this;
    }

    public TypeNameEnum getCategoryType() {
        return categoryType;
    }

    public PicturesBindingModel setCategoryType(TypeNameEnum categoryType) {
        this.categoryType = categoryType;
        return this;
    }

    public StyleNameEnum getCategoryStyle() {
        return categoryStyle;
    }

    public PicturesBindingModel setCategoryStyle(StyleNameEnum categoryStyle) {
        this.categoryStyle = categoryStyle;
        return this;
    }
}

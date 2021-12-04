package com.example.unamoregrande.model.binding;

import com.example.unamoregrande.model.entity.enums.ArticlesNameEnum;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Size;

public class GrandmasSecretArticlesBindingModel {

    @Size(min = 6)
    private String name;
    @Size(min = 50)
    private String description;
    private ArticlesNameEnum category;
    private MultipartFile pictures;

    public GrandmasSecretArticlesBindingModel() {
    }

    public String getName() {
        return name;
    }

    public GrandmasSecretArticlesBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public GrandmasSecretArticlesBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public ArticlesNameEnum getCategory() {
        return category;
    }

    public GrandmasSecretArticlesBindingModel setCategory(ArticlesNameEnum category) {
        this.category = category;
        return this;
    }

    public MultipartFile getPictures() {
        return pictures;
    }

    public GrandmasSecretArticlesBindingModel setPictures(MultipartFile pictures) {
        this.pictures = pictures;
        return this;
    }
}

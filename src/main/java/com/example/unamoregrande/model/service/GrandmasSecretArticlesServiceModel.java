package com.example.unamoregrande.model.service;
import com.example.unamoregrande.model.entity.enums.ArticlesNameEnum;
import org.springframework.web.multipart.MultipartFile;

public class GrandmasSecretArticlesServiceModel {

    private String name;
    private String description;
    private ArticlesNameEnum category;
    private MultipartFile pictures;

    public GrandmasSecretArticlesServiceModel() {
    }

    public String getName() {
        return name;
    }

    public GrandmasSecretArticlesServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public GrandmasSecretArticlesServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public ArticlesNameEnum getCategory() {
        return category;
    }

    public GrandmasSecretArticlesServiceModel setCategory(ArticlesNameEnum category) {
        this.category = category;
        return this;
    }

    public MultipartFile getPictures() {
        return pictures;
    }

    public GrandmasSecretArticlesServiceModel setPictures(MultipartFile pictures) {
        this.pictures = pictures;
        return this;
    }
}

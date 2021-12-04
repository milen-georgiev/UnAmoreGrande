package com.example.unamoregrande.model.binding;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CommentBindingModel {

    @NotBlank
    @Size(min=10)
    private String description;

    public CommentBindingModel() {
    }

    public String getDescription() {
        return description;
    }

    public CommentBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }
}

package com.example.unamoregrande.model.binding;

import javax.validation.constraints.Size;

public class CommentBindingModel {

    @Size(min = 10)
    private String message;

    public CommentBindingModel() {
    }

    public String getDescription() {
        return message;
    }

    public CommentBindingModel setDescription(String description) {
        this.message = message;
        return this;
    }
}

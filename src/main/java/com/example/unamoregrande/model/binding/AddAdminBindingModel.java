package com.example.unamoregrande.model.binding;

import javax.validation.constraints.NotNull;

public class AddAdminBindingModel {

    @NotNull
    private String username;

    public AddAdminBindingModel() {
    }

    public String getUsername() {
        return username;
    }

    public AddAdminBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }
}

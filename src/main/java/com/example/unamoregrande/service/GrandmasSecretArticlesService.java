package com.example.unamoregrande.service;

import com.example.unamoregrande.model.service.GrandmasSecretArticlesServiceModel;
import com.example.unamoregrande.model.view.GrandmasSecretViewModel;

import java.io.IOException;
import java.util.List;

public interface GrandmasSecretArticlesService {

    void addGrandmasSecret(GrandmasSecretArticlesServiceModel grandmasSecretArticlesServiceModel,String user) throws IOException;

    List<GrandmasSecretViewModel> grandmasSecretView();

    GrandmasSecretViewModel findArticlesById(Long id);

    List<GrandmasSecretViewModel> onlyArticlesUser(String username);

}

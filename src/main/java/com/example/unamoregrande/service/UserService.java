package com.example.unamoregrande.service;

import com.example.unamoregrande.model.service.UserRegistrationServiceModel;
import com.example.unamoregrande.model.view.UserViewModel;

public interface UserService {

    void initializeUsersAndRoles();

    void registerAndLoginUser(UserRegistrationServiceModel userRegistrationServiceModel);

    boolean isUserNameFree(String username);

    UserViewModel userDetails(String user);

    void addAdmin(String username);

}

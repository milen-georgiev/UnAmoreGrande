package com.example.unamoregrande.service.impl;

import com.example.unamoregrande.model.entity.UserEntity;
import com.example.unamoregrande.model.entity.UserRoleEntity;
import com.example.unamoregrande.model.entity.enums.RoleNameEnum;
import com.example.unamoregrande.repository.UserRepository;
import com.example.unamoregrande.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Set;
@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    private UserEntity testUser;
    private UserEntity adminTestUser;
    private UserRoleEntity adminRole, userRole;
    private UserService userService;

    @Mock
    private UserRepository mockUserRepository;

    @BeforeEach
    void init() {


        adminRole = new UserRoleEntity();
        adminRole.setName(RoleNameEnum.ADMIN);

        userRole = new UserRoleEntity();
        userRole.setName(RoleNameEnum.USERS);

        adminTestUser = new UserEntity();
        adminTestUser
                .setUsername("admin")
                .setFirstName("admin")
                .setLastName("adminov")
                .setPassword("test")
                .setEmail("admin@adminov")
                .setAge(20)
                .setCreated(LocalDate.now())
                .setRoles(Set.of(adminRole, userRole));

        testUser = new UserEntity();
        testUser
                .setUsername("petko")
                .setFirstName("petko")
                .setLastName("petrov")
                .setPassword("test")
                .setEmail("petko@petrov")
                .setAge(20)
                .setCreated(LocalDate.now())
                .setRoles(Set.of(userRole));
    }

    @Test
    void userDetails() {
    }


    @Test
    void addAdmin() {
    }

    @Test
    void initializeUsersAndRoles() {
    }

    @Test
    void registerAndLoginUser() {
    }

    @Test
    void isUserNameFree() {
    }

    @Test
    void initializeUsers() {
    }
}
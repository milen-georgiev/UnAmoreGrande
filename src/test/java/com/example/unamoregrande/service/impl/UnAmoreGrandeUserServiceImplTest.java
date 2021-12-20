package com.example.unamoregrande.service.impl;

import com.example.unamoregrande.model.entity.UserEntity;
import com.example.unamoregrande.model.entity.UserRoleEntity;
import com.example.unamoregrande.model.entity.enums.RoleNameEnum;
import com.example.unamoregrande.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
@ExtendWith(MockitoExtension.class)
class UnAmoreGrandeUserServiceImplTest {
    private UserEntity testUser;
    private UserEntity adminTestUser;
    private UserRoleEntity adminRole, userRole;
    private UnAmoreGrandeUserServiceImpl serviceTest;


    @Mock
    private UserRepository mockUserRepository;

    @BeforeEach
    void init() {
        serviceTest = new UnAmoreGrandeUserServiceImpl(mockUserRepository);

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
    void testUserNotFound() {
        Assertions.assertThrows(
                UsernameNotFoundException.class,
                () -> serviceTest.loadUserByUsername("stoqn")
        );
    }

    @Test
    void testUserFound() {

        Mockito.when(mockUserRepository.findByUsername(adminTestUser.getUsername()))
                .thenReturn(Optional.of(adminTestUser));

        var actual = serviceTest.loadUserByUsername(adminTestUser.getUsername());

        Assertions.assertEquals(actual.getUsername(), adminTestUser.getUsername());
        String userRole = actual
                .getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(", "));
        String expected = "ROLE_ADMIN, ROLE_USERS";
        Assertions.assertEquals(expected, userRole);
    }
}
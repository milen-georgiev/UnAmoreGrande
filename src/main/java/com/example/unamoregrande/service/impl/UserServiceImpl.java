package com.example.unamoregrande.service.impl;

import com.example.unamoregrande.model.entity.UserEntity;
import com.example.unamoregrande.model.entity.UserRoleEntity;
import com.example.unamoregrande.model.entity.enums.RoleNameEnum;
import com.example.unamoregrande.model.service.UserRegistrationServiceModel;
import com.example.unamoregrande.model.view.UserViewModel;
import com.example.unamoregrande.repository.UserRepository;
import com.example.unamoregrande.repository.UserRoleRepository;
import com.example.unamoregrande.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final ModelMapper modelMapper;
    private final UnAmoreGrandeUserServiceImpl unAmoreGrandeUserService;

    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository,
                           UserRoleRepository userRoleRepository, ModelMapper modelMapper,
                           UnAmoreGrandeUserServiceImpl unAmoreGrandeUserService) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.modelMapper = modelMapper;
        this.unAmoreGrandeUserService = unAmoreGrandeUserService;
    }

    @Override
    public UserViewModel userDetails(String user) {
        UserEntity userEntity = userRepository.findByUsername(user).orElseThrow();

        UserViewModel userViewModel = modelMapper.map(userEntity, UserViewModel.class);

        return userViewModel;
    }

    @Override
    public void initializeUsersAndRoles() {
        initializeRoles();
        initializeUsers();
    }

    @Override
    public void registerAndLoginUser(UserRegistrationServiceModel userRegistrationServiceModel) {
        UserRoleEntity userRole = userRoleRepository.findByName(RoleNameEnum.USERS);

        UserEntity newUser = new UserEntity();

        newUser
                .setUsername(userRegistrationServiceModel.getUsername())
                .setFirstName(userRegistrationServiceModel.getFirstName())
                .setLastName(userRegistrationServiceModel.getLastName())
                .setPassword(passwordEncoder.encode(userRegistrationServiceModel.getPassword()))
                .setEmail(userRegistrationServiceModel.getEmail())
                .setAge(userRegistrationServiceModel.getAge())
                .setCreated(LocalDate.now())
                .setRoles(Set.of(userRole));

        userRepository.save(newUser);

        UserDetails principal = unAmoreGrandeUserService.loadUserByUsername(newUser.getUsername());
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                principal,
                newUser.getPassword(),
                principal.getAuthorities()
        );


        SecurityContextHolder.getContext().setAuthentication(authentication);
    }


    public boolean isUserNameFree(String username) {
        return userRepository
                .findByUsernameIgnoreCase(username)
                .isEmpty();
    }


    public void initializeUsers() {
        if (userRepository.count() == 0) {
            UserRoleEntity adminRole = userRoleRepository.findByName(RoleNameEnum.ADMIN);
            UserRoleEntity userRole = userRoleRepository.findByName(RoleNameEnum.USERS);

            UserEntity admin = new UserEntity();
            admin
                    .setUsername("admin")
                    .setAge(20)
                    .setEmail("admin@Adminov.com")
                    .setFirstName("Admin")
                    .setLastName("Adminov")
                    .setCreated(LocalDate.now())
                    .setPassword(passwordEncoder.encode("test"));

            admin.setRoles(Set.of(adminRole, userRole));
            userRepository.save(admin);
        }

    }

    private void initializeRoles() {

        if (userRoleRepository.count() == 0) {
            UserRoleEntity adminRole = new UserRoleEntity();
            adminRole.setName(RoleNameEnum.ADMIN);

            UserRoleEntity userRole = new UserRoleEntity();
            userRole.setName(RoleNameEnum.USERS);

            userRoleRepository.saveAll(List.of(adminRole, userRole));
        }
    }
}

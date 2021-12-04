package com.example.unamoregrande.model.view;

import com.example.unamoregrande.model.entity.UserRoleEntity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class UserViewModel {

    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private Integer age;
    private String email;
    private LocalDate created;
    private Set<UserRoleEntity> roles = new HashSet<>();

    public UserViewModel() {
    }

    public Long getId() {
        return id;
    }

    public UserViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserViewModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserViewModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserViewModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public UserViewModel setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserViewModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public LocalDate getCreated() {
        return created;
    }

    public UserViewModel setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public Set<UserRoleEntity> getRoles() {
        return roles;
    }

    public UserViewModel setRoles(Set<UserRoleEntity> roles) {
        this.roles = roles;
        return this;
    }
}

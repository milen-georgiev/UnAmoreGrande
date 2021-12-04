package com.example.unamoregrande.model.service;

public class UserRegistrationServiceModel {


    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private Integer age;

    public UserRegistrationServiceModel() {
    }

    public String getUsername() {
        return username != null ?
                username.trim() :
                null;
    }

    public UserRegistrationServiceModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserRegistrationServiceModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserRegistrationServiceModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegistrationServiceModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegistrationServiceModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public UserRegistrationServiceModel setAge(Integer age) {
        this.age = age;
        return this;
    }
}

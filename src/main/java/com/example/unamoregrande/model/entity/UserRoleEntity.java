package com.example.unamoregrande.model.entity;

import com.example.unamoregrande.model.entity.enums.RoleNameEnum;

import javax.persistence.*;

@Entity
@Table(name = "user_roles")
public class UserRoleEntity extends BaseEntity {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleNameEnum name;

    public UserRoleEntity() {
    }

    public RoleNameEnum getName() {
        return name;
    }

    public UserRoleEntity setName(RoleNameEnum name) {
        this.name = name;
        return this;
    }
}

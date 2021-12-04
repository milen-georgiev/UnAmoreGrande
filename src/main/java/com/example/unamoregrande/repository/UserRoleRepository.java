package com.example.unamoregrande.repository;

import com.example.unamoregrande.model.entity.UserRoleEntity;
import com.example.unamoregrande.model.entity.enums.RoleNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {

    UserRoleEntity findByName(RoleNameEnum role);

}

package com.example.unamoregrande.repository;

import com.example.unamoregrande.model.entity.GrandmasSecretArticlesEntity;
import com.example.unamoregrande.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GrandmasSecretArticlesRepository extends JpaRepository<GrandmasSecretArticlesEntity, Long> {

List<GrandmasSecretArticlesEntity> findGrandmasSecretArticlesEntityByPublished(UserEntity userEntity);

}

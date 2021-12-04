package com.example.unamoregrande.repository;

import com.example.unamoregrande.model.entity.GrandmasSecretArticlesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrandmasSecretArticlesRepository extends JpaRepository<GrandmasSecretArticlesEntity, Long> {



}

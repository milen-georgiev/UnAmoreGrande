package com.example.unamoregrande.repository;

import com.example.unamoregrande.model.entity.VideoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VideoRepository extends JpaRepository<VideoEntity, Long> {

}

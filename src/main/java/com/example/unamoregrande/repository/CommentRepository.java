package com.example.unamoregrande.repository;

import com.example.unamoregrande.model.entity.CommentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<CommentsEntity, Long> {


}

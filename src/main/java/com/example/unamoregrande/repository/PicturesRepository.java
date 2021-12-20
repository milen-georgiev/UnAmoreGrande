package com.example.unamoregrande.repository;

import com.example.unamoregrande.model.entity.PicturesEntity;
import com.example.unamoregrande.model.entity.UserEntity;
import com.example.unamoregrande.model.entity.enums.StyleNameEnum;
import com.example.unamoregrande.model.entity.enums.TypeNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PicturesRepository extends JpaRepository<PicturesEntity, Long> {

    List<PicturesEntity> findPicturesEntityByCategoryType(TypeNameEnum type);

    List<PicturesEntity> findPicturesEntityByCategoryTypeAndCategoryStyle(TypeNameEnum type, StyleNameEnum style);

    List<PicturesEntity> findPicturesEntityByUser(UserEntity userEntity);

    //--------- Delete pictures ----------

    void  deleteAllByPublicId(String publicId);

}

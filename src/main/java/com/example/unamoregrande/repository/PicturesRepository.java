package com.example.unamoregrande.repository;

import com.example.unamoregrande.model.entity.PicturesEntity;
import com.example.unamoregrande.model.entity.enums.StyleNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PicturesRepository extends JpaRepository<PicturesEntity, Long> {

    //--------- MANICURE ----------

    @Query("SELECT p FROM PicturesEntity p WHERE p.categoryType = 'HAIRSTYLES'")
    List<PicturesEntity> findCategoryHairstyles();

    @Query("SELECT p FROM PicturesEntity p WHERE p.categoryType = 'HAIRSTYLES' AND p.categoryStyle = ?1")
    List<PicturesEntity> findFilterCategoryHairstyles(StyleNameEnum styleNameEnum);

    //--------- MAKEUP ----------

    @Query("SELECT p FROM PicturesEntity p WHERE p.categoryType = 'MAKEUP'")
    List<PicturesEntity> findCategoryMakeup();

    @Query("SELECT p FROM PicturesEntity p WHERE p.categoryType = 'MAKEUP' AND p.categoryStyle = ?1")
    List<PicturesEntity> findFilterCategoryMakeup(StyleNameEnum styleNameEnum);

    //--------- MANICURE ----------

    @Query("SELECT p FROM PicturesEntity p WHERE p.categoryType = 'MANICURE'")
    List<PicturesEntity> findCategoryManicure();

    @Query("SELECT p FROM PicturesEntity p WHERE p.categoryType = 'MANICURE' AND p.categoryStyle = ?1")
    List<PicturesEntity> findFilterCategoryManicure(StyleNameEnum styleNameEnum);

    //--------- Delete pictures ----------

    void  deleteAllByPublicId(String publicId);

}

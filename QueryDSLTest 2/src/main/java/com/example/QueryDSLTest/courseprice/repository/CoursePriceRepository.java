package com.haksik.haksikapi.courseprice.repository;

import com.haksik.haksikapi.courseprice.model.CoursePriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoursePriceRepository extends JpaRepository<CoursePriceEntity, Long> {

    List<CoursePriceEntity> findByMenuId(Long menuId);
    CoursePriceEntity findByMenuIdAndCourseId(Long menuId, Long courseId);

}

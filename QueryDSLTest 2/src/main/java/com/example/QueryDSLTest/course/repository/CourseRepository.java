package com.haksik.haksikapi.course.repository;

import com.haksik.haksikapi.course.model.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<CourseEntity, Long> {

    List<CourseEntity> findBySchoolId(Long schoolId);

}

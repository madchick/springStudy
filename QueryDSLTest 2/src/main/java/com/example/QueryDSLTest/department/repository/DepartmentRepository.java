package com.haksik.haksikapi.department.repository;

import com.haksik.haksikapi.department.model.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {

    List<DepartmentEntity> findBySchoolId(Long schoolId);

}

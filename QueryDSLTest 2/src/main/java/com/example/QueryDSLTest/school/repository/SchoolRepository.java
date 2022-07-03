package com.haksik.haksikapi.school.repository;

import com.haksik.haksikapi._comm_.codeenum.codedata.DistrictType;
import com.haksik.haksikapi.school.model.SchoolEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface SchoolRepository extends JpaRepository<SchoolEntity, Long> {

    List<SchoolEntity> findAllByOrderBySchoolName();
    List<SchoolEntity> findBySchoolNameContaining(String schoolName);

    List<SchoolEntity> findAllBySchoolNameContainingAndEnabledAndCreatedDateBetweenOrderByCreatedDateDesc(String schoolName, Boolean schoolEnabled, LocalDateTime startDate, LocalDateTime endDate);
    List<SchoolEntity> findAllBySchoolAddressAndSchoolNameContainingAndEnabledAndCreatedDateBetweenOrderByCreatedDateDesc(DistrictType schoolAddress, String schoolName, Boolean schoolEnabled, LocalDateTime startDate, LocalDateTime endDate);
}

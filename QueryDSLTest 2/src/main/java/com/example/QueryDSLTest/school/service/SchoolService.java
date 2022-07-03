package com.haksik.haksikapi.school.service;

import com.haksik.haksikapi._comm_.codeenum.codedata.DistrictType;
import com.haksik.haksikapi.school.model.SchoolEntity;
import com.haksik.haksikapi.school.model.SchoolRequest;
import com.haksik.haksikapi.school.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class SchoolService {

    @Autowired
    private SchoolRepository schoolRepository;

    public SchoolEntity add(SchoolRequest schoolRequest) {
        SchoolEntity schoolEntity = new SchoolEntity();

        schoolEntity.setSchoolName(schoolRequest.getSchoolName());
        schoolEntity.setSchoolAddress(schoolRequest.getSchoolAddress());
        schoolEntity.setCalcFee(schoolRequest.getCalcFee());
        schoolEntity.setCalcClass(schoolRequest.getCalcClass());
        schoolEntity.setCalcType(schoolRequest.getCalcType());
        schoolEntity.setCalcCycle(schoolRequest.getCalcCycle());
        schoolEntity.setPersonName(schoolRequest.getPersonName());
        schoolEntity.setPersonPhoneNumber(schoolRequest.getPersonPhoneNumber());
        schoolEntity.setSchoolPhoneNumber(schoolRequest.getSchoolPhoneNumber());
        schoolEntity.setUserAccount(schoolRequest.getUserId());
        schoolEntity.setEnabled(true);

        return this.schoolRepository.save(schoolEntity);
    }

    public SchoolEntity searchById(Long id) {
        return this.schoolRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public SchoolEntity updateById(Long id, SchoolRequest schoolRequest) {
        SchoolEntity schoolEntity = this.searchById(id);

        schoolEntity.setSchoolName(schoolRequest.getSchoolName());
        schoolEntity.setSchoolAddress(schoolRequest.getSchoolAddress());
        schoolEntity.setCalcFee(schoolRequest.getCalcFee());
        schoolEntity.setCalcClass(schoolRequest.getCalcClass());
        schoolEntity.setCalcType(schoolRequest.getCalcType());
        schoolEntity.setCalcCycle(schoolRequest.getCalcCycle());
        schoolEntity.setPersonName(schoolRequest.getPersonName());
        schoolEntity.setPersonPhoneNumber(schoolRequest.getPersonPhoneNumber());
        schoolEntity.setSchoolPhoneNumber(schoolRequest.getSchoolPhoneNumber());

        schoolEntity.setEnabled(schoolRequest.getSchoolEnable());
        schoolEntity.setModifiedDate(LocalDateTime.now());

        return this.schoolRepository.save(schoolEntity);
    }

    public List<SchoolEntity> searchAll() {
        return this.schoolRepository.findAllByOrderBySchoolName();
    }

    public List<SchoolEntity> searchAllWithCondition(
            String schoolName,
            DistrictType schoolAddress,
            Boolean schoolEnabled,
            LocalDateTime startDate,
            LocalDateTime endDate
    ) {
        if (schoolAddress == DistrictType.ALL)
            return this.schoolRepository.findAllBySchoolNameContainingAndEnabledAndCreatedDateBetweenOrderByCreatedDateDesc(schoolName,schoolEnabled, startDate, endDate);
        else
            return this.schoolRepository.findAllBySchoolAddressAndSchoolNameContainingAndEnabledAndCreatedDateBetweenOrderByCreatedDateDesc(schoolAddress, schoolName,schoolEnabled, startDate, endDate);
    }

    public List<SchoolEntity> searchByName(String schoolName) {
        return this.schoolRepository.findBySchoolNameContaining(schoolName);
    }

    public void deleteById(Long id) {
        SchoolEntity schoolEntity = this.searchById(id);
        schoolEntity.setEnabled(false);

        this.schoolRepository.save(schoolEntity);
    }

}

package com.haksik.haksikapi.department.service;

import com.haksik.haksikapi.department.model.DepartmentEntity;
import com.haksik.haksikapi.department.model.DepartmentRequest;
import com.haksik.haksikapi.department.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public DepartmentEntity add(DepartmentRequest departmentRequest) {
        DepartmentEntity departmentEntity = new DepartmentEntity();

        departmentEntity.setSchoolId(departmentRequest.getSchoolId());
        departmentEntity.setDepartmentName(departmentRequest.getDepartmentName());
        departmentEntity.setDepartmentDesc(departmentRequest.getDepartmentDesc());
        departmentEntity.setEnabled(true);

        return this.departmentRepository.save(departmentEntity);
    }

    public DepartmentEntity searchById(Long id) {
        return this.departmentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public DepartmentEntity updateById(Long id, DepartmentRequest departmentRequest) {
        DepartmentEntity departmentEntity = this.searchById(id);

        departmentEntity.setSchoolId(departmentRequest.getSchoolId());
        departmentEntity.setDepartmentName(departmentRequest.getDepartmentName());
        departmentEntity.setDepartmentDesc(departmentRequest.getDepartmentDesc());
        departmentEntity.setEnabled(departmentRequest.getDepartmentEnabled());

        departmentEntity.setModifiedDate(LocalDateTime.now());

        return this.departmentRepository.save(departmentEntity);
    }

    public void deleteById(Long id) {
        DepartmentEntity departmentEntity = this.searchById(id);
        departmentEntity.setEnabled(false);

        this.departmentRepository.save(departmentEntity);
    }

    public List<DepartmentEntity> searchBySchoolId(Long schoolId) { return this.departmentRepository.findBySchoolId(schoolId); }

}

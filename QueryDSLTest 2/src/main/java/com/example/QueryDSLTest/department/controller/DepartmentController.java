package com.haksik.haksikapi.department.controller;

import com.haksik.haksikapi._comm_.codeenum.codedata.CustomerType;
import com.haksik.haksikapi.department.model.DepartmentEntity;
import com.haksik.haksikapi.department.model.DepartmentRequest;
import com.haksik.haksikapi.department.model.DepartmentResponse;
import com.haksik.haksikapi.department.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping("/admin/department")
    @Transactional
    // @PreAuthorize("isAuthenticated()")
    public ResponseEntity<DepartmentResponse> create(@RequestBody DepartmentRequest departmentRequest) {
        DepartmentEntity departmentEntity = this.departmentService.add(departmentRequest);

        List<DepartmentEntity> departmentEntities = new ArrayList<>();
        departmentEntities.add(departmentEntity);

        DepartmentResponse departmentResponse = new DepartmentResponse();
        departmentResponse.setStatus("200");
        departmentResponse.setError("success");
        departmentResponse.setDepartmentEntities(departmentEntities);

        return ResponseEntity.ok(departmentResponse);
    }

    @GetMapping("/admin/department/{id}")
    // @PreAuthorize("isAuthenticated()")
    public ResponseEntity<DepartmentResponse> readOne(@PathVariable Long id) {
        DepartmentEntity departmentEntity = this.departmentService.searchById(id);

        List<DepartmentEntity> departmentEntities = new ArrayList<>();
        departmentEntities.add(departmentEntity);

        DepartmentResponse departmentResponse = new DepartmentResponse();
        departmentResponse.setStatus("200");
        departmentResponse.setError("success");
        departmentResponse.setDepartmentEntities(departmentEntities);

        return ResponseEntity.ok(departmentResponse);
    }

    @PutMapping("/admin/department/{id}")
    // @PreAuthorize("isAuthenticated()")
    public ResponseEntity<DepartmentResponse> update(
            @PathVariable Long id,
            @RequestBody DepartmentRequest departmentRequest)
    {
        DepartmentEntity departmentEntity = this.departmentService.updateById(id, departmentRequest);

        List<DepartmentEntity> departmentEntities = new ArrayList<>();
        departmentEntities.add(departmentEntity);

        DepartmentResponse departmentResponse = new DepartmentResponse();
        departmentResponse.setStatus("200");
        departmentResponse.setError("success");
        departmentResponse.setDepartmentEntities(departmentEntities);

        return ResponseEntity.ok(departmentResponse);
    }

    @DeleteMapping("/admin/department/{id}")
    // @PreAuthorize("isAuthenticated()")
    public ResponseEntity<DepartmentResponse> deleteOne(@PathVariable Long id) {
        this.departmentService.deleteById(id);

        DepartmentResponse departmentResponse = new DepartmentResponse();
        departmentResponse.setStatus("200");
        departmentResponse.setError("success");

        return ResponseEntity.ok(departmentResponse);
    }

    @GetMapping("/mobileapp/department/browse")
    // @PreAuthorize("isAuthenticated()")
    public ResponseEntity<DepartmentResponse> browse(@RequestParam Long schoolid) {
        List<DepartmentEntity> shopEntities = this.departmentService.searchBySchoolId(schoolid);

        DepartmentResponse departmentResponse = new DepartmentResponse();
        departmentResponse.setStatus("200");
        departmentResponse.setError("success");
        departmentResponse.setDepartmentEntities(shopEntities);

        return ResponseEntity.ok(departmentResponse);
    }

}

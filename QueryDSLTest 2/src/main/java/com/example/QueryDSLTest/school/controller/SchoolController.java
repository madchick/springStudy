package com.haksik.haksikapi.school.controller;

import com.haksik.haksikapi._comm_.codeenum.codedata.CustomerType;
import com.haksik.haksikapi._comm_.codeenum.codedata.DistrictType;
import com.haksik.haksikapi.school.model.SchoolEntity;
import com.haksik.haksikapi.school.model.SchoolRequest;
import com.haksik.haksikapi.school.model.SchoolResponse;
import com.haksik.haksikapi.school.service.SchoolService;
import com.haksik.haksikapi.user.model.UserEntity;
import com.haksik.haksikapi.user.model.UserRequest;
import com.haksik.haksikapi.user.service.UserAuthService;
import com.haksik.haksikapi.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
public class SchoolController {

    private final SchoolService shoolService;
    private final UserService userService;
    private final UserAuthService userAuthService;

    @PostMapping("/admin/school")
    @Transactional
    public ResponseEntity<SchoolResponse> create(@RequestBody SchoolRequest schoolRequest) {
        SchoolResponse schoolResponse = new SchoolResponse();
        List<UserEntity> userEntities = this.userService.searchByEmail(schoolRequest.getUserId());
        if(userEntities.stream().count() != 0) {
            schoolResponse.setStatus("400");
            schoolResponse.setError("이미 등록된 계정 입니다.");
            return ResponseEntity.ok(schoolResponse);
        }

        SchoolEntity schoolEntity = this.shoolService.add(schoolRequest);

        UserRequest userRequest = new UserRequest();
        userRequest.setEmail(schoolRequest.getUserId());
        userRequest.setPassword(schoolRequest.getUserPw());
        userRequest.setName(schoolRequest.getPersonName());
        userRequest.setPhone(schoolRequest.getPersonPhoneNumber());
        userRequest.setSchoolId(schoolEntity.getSchoolId());
        userRequest.setIdNumber("");
        userRequest.setCustomerType(CustomerType.SCHOOLADMIN);
        UserEntity userEntity = this.userService.add(userRequest);
        this.userAuthService.addAuthority(userEntity.getUserId(),"ROLE_SHOP");

        List<SchoolEntity> schoolEntities = new ArrayList<>();
        schoolEntities.add(schoolEntity);

        schoolResponse.setStatus("200");
        schoolResponse.setError("success");
        schoolResponse.setSchoolEntities(schoolEntities);

        return ResponseEntity.ok(schoolResponse);
    }

    @GetMapping("/admin/school/{id}")
    // @PreAuthorize("isAuthenticated()")
    public ResponseEntity<SchoolResponse> readOne(@PathVariable Long id) {
        SchoolEntity schoolEntity = this.shoolService.searchById(id);

        List<SchoolEntity> userEntities = new ArrayList<>();
        userEntities.add(schoolEntity);

        SchoolResponse schoolResponse = new SchoolResponse();
        schoolResponse.setStatus("200");
        schoolResponse.setError("success");
        schoolResponse.setSchoolEntities(userEntities);

        return ResponseEntity.ok(schoolResponse);
    }

    @PutMapping("/admin/school/{id}")
    // @PreAuthorize("isAuthenticated()")
    public ResponseEntity<SchoolResponse> update(
            @PathVariable Long id,
            @RequestBody SchoolRequest schoolRequest)
    {
        SchoolEntity schoolEntity = this.shoolService.updateById(id, schoolRequest);

        List<SchoolEntity> schoolEntities = new ArrayList<>();
        schoolEntities.add(schoolEntity);

        SchoolResponse schoolResponse = new SchoolResponse();
        schoolResponse.setStatus("200");
        schoolResponse.setError("success");
        schoolResponse.setSchoolEntities(schoolEntities);

        return ResponseEntity.ok(schoolResponse);
    }

    @DeleteMapping("/admin/school/{id}")
    // @PreAuthorize("isAuthenticated()")
    public ResponseEntity<SchoolResponse> deleteOne(@PathVariable Long id) {
        this.shoolService.deleteById(id);

        SchoolResponse schoolResponse = new SchoolResponse();
        schoolResponse.setStatus("200");
        schoolResponse.setError("success");

        return ResponseEntity.ok(schoolResponse);
    }

    @GetMapping("/admin/school")
    public ResponseEntity<SchoolResponse> querySchool(
            @RequestParam(defaultValue = "") String schoolName,
            @RequestParam DistrictType schoolAddress,
            @RequestParam(defaultValue = "true") Boolean schoolEnabled,
            @RequestParam(defaultValue = "2022-01-01T00:00:00") @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss") LocalDateTime startDate,
            @RequestParam(defaultValue = "2999-12-31T23:59:59") @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss") LocalDateTime endDate)
    {
        List<SchoolEntity> schoolEntities = this.shoolService.searchAllWithCondition(schoolName,schoolAddress,schoolEnabled,startDate,endDate);

        SchoolResponse schoolResponse = new SchoolResponse();
        schoolResponse.setStatus("200");
        schoolResponse.setError("success");
        schoolResponse.setSchoolEntities(schoolEntities);

        return ResponseEntity.ok(schoolResponse);
    }

    @GetMapping("/mobileapp/school")
    public ResponseEntity<SchoolResponse> queryAll() {
        // ToDo : enabled 조건 걸기
        List<SchoolEntity> schoolEntities = this.shoolService.searchAll();

        SchoolResponse schoolResponse = new SchoolResponse();
        schoolResponse.setStatus("200");
        schoolResponse.setError("success");
        schoolResponse.setSchoolEntities(schoolEntities);

        return ResponseEntity.ok(schoolResponse);
    }

    @GetMapping("/mobileapp/school/browse")
    public ResponseEntity<SchoolResponse> queryByName(@RequestParam String schoolName) {
        List<SchoolEntity> schoolEntities = this.shoolService.searchByName(schoolName);

        SchoolResponse schoolResponse = new SchoolResponse();
        schoolResponse.setStatus("200");
        schoolResponse.setError("success");
        schoolResponse.setSchoolEntities(schoolEntities);

        return ResponseEntity.ok(schoolResponse);
    }
}

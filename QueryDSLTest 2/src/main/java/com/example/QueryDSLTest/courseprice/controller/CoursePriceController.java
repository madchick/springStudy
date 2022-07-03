package com.haksik.haksikapi.courseprice.controller;

import com.haksik.haksikapi.courseprice.model.CoursePriceEntity;
import com.haksik.haksikapi.courseprice.model.CoursePriceRequest;
import com.haksik.haksikapi.courseprice.model.CoursePriceResponse;
import com.haksik.haksikapi.courseprice.service.CoursePriceService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
public class CoursePriceController {

    private final CoursePriceService coursePriceService;

    @PostMapping("/admin/courseprice")
    @Transactional
    // @PreAuthorize("isAuthenticated()")
    public ResponseEntity<CoursePriceResponse> create(@RequestBody CoursePriceRequest coursePriceRequest) {
        CoursePriceEntity coursePriceEntity = this.coursePriceService.searchById(coursePriceRequest.getMenuId(), coursePriceRequest.getCourseId());

        CoursePriceResponse coursePriceResponse = new CoursePriceResponse();
        if(coursePriceEntity != null) {
            coursePriceResponse.setStatus("400");
            coursePriceResponse.setError("중복 등록할 수 없습니다");
            return ResponseEntity.ok(coursePriceResponse);
        }

        coursePriceEntity = this.coursePriceService.add(coursePriceRequest);

        List<CoursePriceEntity> coursePriceEntities = new ArrayList<>();
        coursePriceEntities.add(coursePriceEntity);

        coursePriceResponse.setStatus("200");
        coursePriceResponse.setError("success");
        coursePriceResponse.setCoursePriceEntities(coursePriceEntities);

        return ResponseEntity.ok(coursePriceResponse);
    }

    @PutMapping("/admin/courseprice")
    // @PreAuthorize("isAuthenticated()")
    public ResponseEntity<CoursePriceResponse> update(@RequestBody CoursePriceRequest coursePriceRequest)
    {
        CoursePriceEntity coursePriceEntity = this.coursePriceService.updateById(coursePriceRequest);

        List<CoursePriceEntity> coursePriceEntities = new ArrayList<>();
        coursePriceEntities.add(coursePriceEntity);

        CoursePriceResponse coursePriceResponse = new CoursePriceResponse();
        coursePriceResponse.setStatus("200");
        coursePriceResponse.setError("success");
        coursePriceResponse.setCoursePriceEntities(coursePriceEntities);

        return ResponseEntity.ok(coursePriceResponse);
    }

    @DeleteMapping("/admin/courseprice")
    // @PreAuthorize("isAuthenticated()")
    public ResponseEntity<CoursePriceResponse> deleteOne(@RequestBody CoursePriceRequest coursePriceRequest) {
        this.coursePriceService.deleteById(coursePriceRequest);

        CoursePriceResponse coursePriceResponse = new CoursePriceResponse();
        coursePriceResponse.setStatus("200");
        coursePriceResponse.setError("success");

        return ResponseEntity.ok(coursePriceResponse);
    }

    @GetMapping("/admin/courseprice/browse")
    // @PreAuthorize("isAuthenticated()")
    public ResponseEntity<CoursePriceResponse> browse(@RequestParam Long menuid) {
        List<CoursePriceEntity> coursePriceEntities = this.coursePriceService.searchByMenuId(menuid);

        CoursePriceResponse coursePriceResponse = new CoursePriceResponse();
        coursePriceResponse.setStatus("200");
        coursePriceResponse.setError("success");
        coursePriceResponse.setCoursePriceEntities(coursePriceEntities);

        return ResponseEntity.ok(coursePriceResponse);
    }

}

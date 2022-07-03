package com.haksik.haksikapi.course.controller;

import com.haksik.haksikapi.course.model.CourseEntity;
import com.haksik.haksikapi.course.model.CourseRequest;
import com.haksik.haksikapi.course.model.CourseResponse;
import com.haksik.haksikapi.course.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
public class CourseController {

    private final CourseService courseService;

    @PostMapping("/admin/course")
    @Transactional
    // @PreAuthorize("isAuthenticated()")
    public ResponseEntity<CourseResponse> create(@RequestBody CourseRequest courseRequest) {
        CourseEntity courseEntity = this.courseService.add(courseRequest);

        List<CourseEntity> courseEntities = new ArrayList<>();
        courseEntities.add(courseEntity);

        CourseResponse courseResponse = new CourseResponse();
        courseResponse.setStatus("200");
        courseResponse.setError("success");
        courseResponse.setCourseEntities(courseEntities);

        return ResponseEntity.ok(courseResponse);
    }

    @GetMapping("/admin/course/{id}")
    // @PreAuthorize("isAuthenticated()")
    public ResponseEntity<CourseResponse> readOne(@PathVariable Long id) {
        CourseEntity courseEntity = this.courseService.searchById(id);

        List<CourseEntity> courseEntities = new ArrayList<>();
        courseEntities.add(courseEntity);

        CourseResponse courseResponse = new CourseResponse();
        courseResponse.setStatus("200");
        courseResponse.setError("success");
        courseResponse.setCourseEntities(courseEntities);

        return ResponseEntity.ok(courseResponse);
    }

    @PutMapping("/admin/course/{id}")
    // @PreAuthorize("isAuthenticated()")
    public ResponseEntity<CourseResponse> update(
            @PathVariable Long id,
            @RequestBody CourseRequest courseRequest)
    {
        CourseEntity courseEntity = this.courseService.updateById(id, courseRequest);

        List<CourseEntity> courseEntities = new ArrayList<>();
        courseEntities.add(courseEntity);

        CourseResponse courseResponse = new CourseResponse();
        courseResponse.setStatus("200");
        courseResponse.setError("success");
        courseResponse.setCourseEntities(courseEntities);

        return ResponseEntity.ok(courseResponse);
    }

    @DeleteMapping("/admin/course/{id}")
    // @PreAuthorize("isAuthenticated()")
    public ResponseEntity<CourseResponse> deleteOne(@PathVariable Long id) {
        this.courseService.deleteById(id);

        CourseResponse courseResponse = new CourseResponse();
        courseResponse.setStatus("200");
        courseResponse.setError("success");

        return ResponseEntity.ok(courseResponse);
    }

    @GetMapping("/mobileapp/course/browse")
    // @PreAuthorize("isAuthenticated()")
    public ResponseEntity<CourseResponse> browse(@RequestParam Long schoolid) {
        List<CourseEntity> courseEntities = this.courseService.searchBySchoolId(schoolid);

        CourseResponse courseResponse = new CourseResponse();
        courseResponse.setStatus("200");
        courseResponse.setError("success");
        courseResponse.setCourseEntities(courseEntities);

        return ResponseEntity.ok(courseResponse);
    }

}

package com.haksik.haksikapi.course.service;

import com.haksik.haksikapi.course.model.CourseEntity;
import com.haksik.haksikapi.course.model.CourseRequest;
import com.haksik.haksikapi.course.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity add(CourseRequest courseRequest) {
        CourseEntity courseEntity = new CourseEntity();

        courseEntity.setSchoolId(courseRequest.getSchoolId());
        courseEntity.setCourseName(courseRequest.getCourseName());
        courseEntity.setCourseDesc(courseRequest.getCourseDesc());
        courseEntity.setEnabled(true);

        return this.courseRepository.save(courseEntity);
    }

    public CourseEntity searchById(Long id) {
        return this.courseRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public CourseEntity updateById(Long id, CourseRequest courseRequest) {
        CourseEntity courseEntity = this.searchById(id);

        courseEntity.setSchoolId(courseRequest.getSchoolId());
        courseEntity.setCourseName(courseRequest.getCourseName());
        courseEntity.setCourseDesc(courseRequest.getCourseDesc());
        courseEntity.setEnabled(courseRequest.getCourseEnabled());

        courseEntity.setModifiedDate(LocalDateTime.now());

        return this.courseRepository.save(courseEntity);
    }

    public void deleteById(Long id) {
        CourseEntity courseEntity = this.searchById(id);
        courseEntity.setEnabled(false);

        this.courseRepository.save(courseEntity);
    }

    public List<CourseEntity> searchBySchoolId(Long schoolId) { return this.courseRepository.findBySchoolId(schoolId); }

}

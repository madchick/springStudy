package com.haksik.haksikapi.course.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseRequest {

    private Long schoolId;
    private String courseName;
    private String courseDesc;
    private Boolean courseEnabled;

}

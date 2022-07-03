package com.haksik.haksikapi.course.model;

import com.haksik.haksikapi._comm_.model.BaseResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CourseResponse extends BaseResponse {

    public CourseResponse() {
        super();
        this.setPath("/mobileapp/course");
    }

    private List<CourseEntity> courseEntities;

}

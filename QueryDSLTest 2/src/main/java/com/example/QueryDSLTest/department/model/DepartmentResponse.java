package com.haksik.haksikapi.department.model;

import com.haksik.haksikapi._comm_.model.BaseResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DepartmentResponse extends BaseResponse {

    public DepartmentResponse() {
        super();
        this.setPath("/mobileapp/department");
    }

    private List<DepartmentEntity> departmentEntities;

}

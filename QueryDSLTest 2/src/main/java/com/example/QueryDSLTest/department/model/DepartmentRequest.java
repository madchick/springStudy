package com.haksik.haksikapi.department.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DepartmentRequest {

    private Long schoolId;
    private String departmentName;
    private String departmentDesc;
    private Boolean departmentEnabled;

}

package com.haksik.haksikapi.school.model;

import com.haksik.haksikapi._comm_.model.BaseResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SchoolResponse  extends BaseResponse {

    public SchoolResponse() {
        super();
        this.setPath("/mobileapp/school");
    }

    private List<SchoolEntity> schoolEntities;

}

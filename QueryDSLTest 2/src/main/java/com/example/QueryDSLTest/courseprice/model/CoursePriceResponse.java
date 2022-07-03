package com.haksik.haksikapi.courseprice.model;

import com.haksik.haksikapi._comm_.model.BaseResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CoursePriceResponse extends BaseResponse {

    public CoursePriceResponse() {
        super();
        this.setPath("/admin/courseprice");
    }

    private List<CoursePriceEntity> coursePriceEntities;

}

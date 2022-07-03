package com.haksik.haksikapi.courseprice.model;

import com.haksik.haksikapi._comm_.codeenum.codedata.MealType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CoursePriceRequest {

    private Long menuId;

    private Long courseId;

    private Long coursePrice;

    private Boolean coursePriceEnabled;

}

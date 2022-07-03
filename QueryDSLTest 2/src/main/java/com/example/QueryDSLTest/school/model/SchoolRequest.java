package com.haksik.haksikapi.school.model;

import com.haksik.haksikapi._comm_.codeenum.codedata.CalcClassType;
import com.haksik.haksikapi._comm_.codeenum.codedata.CalcType;
import com.haksik.haksikapi._comm_.codeenum.codedata.DistrictType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SchoolRequest {

    private String schoolName;

    private DistrictType schoolAddress;

    private String userId;
    private String userPw;

    private Long calcCycle;

    private Double calcFee;

    private CalcClassType calcClass;

    private CalcType calcType;

    private String personName;

    private String personPhoneNumber;

    private String schoolPhoneNumber;

    private String fileName;

    private Boolean schoolEnable;

}

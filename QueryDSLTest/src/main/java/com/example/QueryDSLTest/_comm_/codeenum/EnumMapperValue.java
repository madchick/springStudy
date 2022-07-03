package com.example.QueryDSLTest._comm_.codeenum;

import lombok.Getter;

@Getter
public class EnumMapperValue {

    private String code;
    private String title;

    public EnumMapperValue(EnumMapperType enumMapperType) {
        code = enumMapperType.getCode();
        title = enumMapperType.getTitle();
    }

}

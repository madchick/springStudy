package com.haksik.haksikapi._comm_.codeenum;

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

package com.haksik.haksikapi._comm_.codeenum.codedata;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.haksik.haksikapi._comm_.codeenum.EnumMapperType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum CalcClassType implements EnumMapperType {

    CALC_CLASS_TYPE_A("정산A"),
    CALC_CLASS_TYPE_B("정산B"),
    CALC_CLASS_TYPE_C("정산C");

    @Getter
    // @JsonValue
    private final String title;

    @Override
    public String getCode() {
        return name();
    }

}

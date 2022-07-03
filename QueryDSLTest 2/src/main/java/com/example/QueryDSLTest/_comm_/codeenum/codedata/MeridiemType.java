package com.haksik.haksikapi._comm_.codeenum.codedata;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.haksik.haksikapi._comm_.codeenum.EnumMapperType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum MeridiemType implements EnumMapperType {

    AM("오전"),
    PM("오후");

    @Getter
    // @JsonValue
    private final String title;

    @Override
    public String getCode() {
        return name();
    }

}

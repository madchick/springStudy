package com.haksik.haksikapi._comm_.codeenum.codedata;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import com.haksik.haksikapi._comm_.codeenum.EnumMapperType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum CustomerType implements EnumMapperType {

    STUDENT("학생"),
    EMPLOYEE("교직원"),
    ADMIN("전체관리자"),
    SHOPADMIN("식당관리자"),
    SCHOOLADMIN("학교관리자");

    @Getter
    // @JsonValue
    private final String title;

    @Override
    public String getCode() {
        return name();
    }

}

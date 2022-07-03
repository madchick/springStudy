package com.example.QueryDSLTest._comm_.codeenum.codedata;

import com.example.QueryDSLTest._comm_.codeenum.EnumMapperType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum UserType implements EnumMapperType {

    ADMIN("관리자"),
    USER("회원");

    @Getter
    // @JsonValue
    private final String title;

    @Override
    public String getCode() {
        return name();
    }

}

package com.haksik.haksikapi._comm_.codeenum.codedata;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import com.haksik.haksikapi._comm_.codeenum.EnumMapperType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TicketType implements EnumMapperType {

    PAYNOW("일반"),
    PREPAID("선불"),
    PAYLATER("후불");

    @Getter
    // @JsonValue
    private final String title;

    @Override
    public String getCode() {
        return name();
    }

}

package com.haksik.haksikapi.menu.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.haksik.haksikapi._comm_.codeenum.codedata.GopublicType;
import com.haksik.haksikapi._comm_.codeenum.codedata.MealType;
import com.haksik.haksikapi._comm_.codeenum.codedata.SalesStatusType;
import com.haksik.haksikapi._comm_.codeenum.codedata.TicketType;

import java.time.LocalDateTime;

public interface MenuGroupView {

    Long getMenuId();
    String getMenuName();
    Long getMenuPrice();
    Long getShopId();
    String getShopName();
    Long getSchoolId();
    String getSchoolName();
    TicketType getTicketType();
    String getMenuDesc();
    String getMenuDetailDesc();
    String getMenuPicture();

    GopublicType getGopublicType();

    SalesStatusType getSalesStatusType();

    MealType getMealType();

    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDateTime getSalesStartDate();

    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDateTime getSalesStopDate();

    Boolean getEnabled();

    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDateTime getCreatedDate();

}

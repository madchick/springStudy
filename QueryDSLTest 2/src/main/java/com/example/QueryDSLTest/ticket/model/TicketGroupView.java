package com.haksik.haksikapi.ticket.model;

import com.haksik.haksikapi._comm_.codeenum.codedata.MealType;
import com.haksik.haksikapi._comm_.codeenum.codedata.TicketType;

import java.time.LocalDateTime;

public interface TicketGroupView {
    Long getOrderId();
    String getSchoolName();
    String getShopName();
    TicketType getTicketType();
    MealType getMealType();
    String getMenuPicture();
    String getMenuName();
    String getBuyDate();
    Long getTicketPrice();
    Long getTotalCount();
    Long getItemCount();
}

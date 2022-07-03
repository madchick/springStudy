package com.haksik.haksikapi.order.model;

import com.haksik.haksikapi._comm_.codeenum.codedata.MealType;

public interface OrderinfoView {
    Long getSchoolId();
    String getSchoolName();
    Long getShopId();
    String getShopName();
    Long getMenuId();
    String getMenuName();
    String getMenuPicture();
    Long getTicketPrice();
    MealType getMealType();
    String getMenuDesc();
    String getMenuDetailDesc();

    Long getItemBundleCount();
}

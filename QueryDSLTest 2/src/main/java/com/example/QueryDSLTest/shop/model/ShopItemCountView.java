package com.haksik.haksikapi.shop.model;

import com.haksik.haksikapi._comm_.codeenum.codedata.MealType;

public interface ShopItemCountView {
    MealType getMealType();
    Long getItemCount();
}

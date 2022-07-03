package com.haksik.haksikapi.item.model;

import com.haksik.haksikapi._comm_.codeenum.codedata.MealType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemRequest {

    private Long shopId;

    private Long menuId;
    private String menuPicture;

    private String itemName;

    private Long itemBundleCount;

    private Long itemPrice;

    private MealType mealType;

    private String itemDesc;
    private String itemDetailDesc;

    private Boolean itemEnabled;
}

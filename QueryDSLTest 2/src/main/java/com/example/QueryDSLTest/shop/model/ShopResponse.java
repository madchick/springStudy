package com.haksik.haksikapi.shop.model;

import com.haksik.haksikapi._comm_.model.BaseResponse;
import com.haksik.haksikapi.item.model.ItemEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ShopResponse extends BaseResponse {

    public ShopResponse() {
        super();
        this.setPath("/mobileapp/shop");
    }

    private List<ShopEntity> shopEntities;
    private List<ItemEntity> itemEntities;

    private List<ShopItemCountView> shopItemCountViews;

}

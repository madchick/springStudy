package com.haksik.haksikapi.item.model;

import com.haksik.haksikapi._comm_.model.BaseResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ItemResponse extends BaseResponse {

    public ItemResponse() {
        super();
        this.setPath("/mobileapp/item");
    }

    private List<ItemEntity> itemEntities;

}

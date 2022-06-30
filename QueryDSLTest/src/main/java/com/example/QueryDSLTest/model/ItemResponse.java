package com.example.QueryDSLTest.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ItemResponse extends BaseResponse {

    public ItemResponse() {
        super();
        this.setPath("/test/item");
    }

    private List<ItemEntity> itemEntities;

}

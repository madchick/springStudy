package com.haksik.haksikapi.order.model;

import com.haksik.haksikapi._comm_.model.BaseResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderResponse extends BaseResponse {

    public OrderResponse() {
        super();
        this.setPath("/mobileapp/order");
    }

    private List<OrderEntity> orderEntities;

}

package com.haksik.haksikapi.order.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequest {

    private Long userId;

    private Long creditcardId;

    private Long itemId;

    private Long itemCount;

    private Long paidPrice;

    private Long paidPoint;

}

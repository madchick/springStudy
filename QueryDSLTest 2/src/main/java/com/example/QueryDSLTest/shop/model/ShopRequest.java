package com.haksik.haksikapi.shop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShopRequest {
    private Long schoolId;

    private String shopName;

    private String shopLocation;

    private String shopHoliday;

    private String menulistUrl;

    private String shopAccount;

    private String shopAccountPw;

    private Boolean shopEnabled;
}

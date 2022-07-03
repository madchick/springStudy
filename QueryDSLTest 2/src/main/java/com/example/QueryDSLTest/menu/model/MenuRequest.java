package com.haksik.haksikapi.menu.model;

import com.haksik.haksikapi._comm_.codeenum.codedata.GopublicType;
import com.haksik.haksikapi._comm_.codeenum.codedata.MealType;
import com.haksik.haksikapi._comm_.codeenum.codedata.SalesStatusType;
import com.haksik.haksikapi._comm_.codeenum.codedata.TicketType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MenuRequest {

    private Long shopId;

    private String menuName;

    private String menuDesc;
    private String menuDetailDesc;

    private Long menuPrice;

    private String menuPicture;

    private TicketType ticketType;

    private SalesStatusType salesStatusType;

    private GopublicType gopublicType;

    private LocalDateTime salesStartDate;
    private LocalDateTime salesStopDate;

    private MealType mealType;
    private String mealType1;
    private String mealType2;
    private String mealType3;

    private Boolean menuEnabled;

}

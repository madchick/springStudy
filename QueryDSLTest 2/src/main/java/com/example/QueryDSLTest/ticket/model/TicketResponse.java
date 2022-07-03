package com.haksik.haksikapi.ticket.model;

import com.haksik.haksikapi._comm_.model.BaseResponse;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TicketResponse extends BaseResponse {

    public TicketResponse() {
        super();
        this.setPath("/mobileapp/ticket");
    }

    private int ticketTotalCount;

    private List<TicketEntity> ticketEntities;
    private List<TicketGroupView> ticketGroupViews;

}

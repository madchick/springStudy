package com.haksik.haksikapi.order.controller;

import com.haksik.haksikapi._comm_.codeenum.codedata.TicketType;
import com.haksik.haksikapi.order.model.OrderEntity;
import com.haksik.haksikapi.order.model.OrderRequest;
import com.haksik.haksikapi.order.model.OrderResponse;
import com.haksik.haksikapi.order.model.OrderinfoView;
import com.haksik.haksikapi.order.service.OrderService;
import com.haksik.haksikapi.ticket.model.TicketEntity;
import com.haksik.haksikapi.ticket.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/mobileapp/order")
public class OrderController {

    private final OrderService orderService;
    private final TicketService ticketService;

    @PostMapping
    @Transactional
    public ResponseEntity<OrderResponse> create(@RequestBody OrderRequest orderRequest) {
        OrderResponse orderResponse = new OrderResponse();

        // ToDo : 본인 등록 신용카드인지 확인
        // ToDo : 결제

        OrderEntity orderEntity = this.orderService.add(orderRequest);
        List<OrderEntity> orderEntities = new ArrayList<>();
        orderEntities.add(orderEntity);

        OrderinfoView orderinfoView = this.orderService.searchOrderInfo(orderRequest.getItemId());
        for (int i=0 ; i<orderinfoView.getItemBundleCount() ; i++) {
            TicketEntity ticketEntity = new TicketEntity();
            ticketEntity.setUserId(orderRequest.getUserId());
            ticketEntity.setOrderId(orderEntity.getOrderId());
            ticketEntity.setSchoolId(orderinfoView.getSchoolId());
            ticketEntity.setSchoolName(orderinfoView.getSchoolName());
            ticketEntity.setShopId(orderinfoView.getShopId());
            ticketEntity.setShopName(orderinfoView.getShopName());
            ticketEntity.setMenuId(orderinfoView.getMenuId());
            ticketEntity.setMenuName(orderinfoView.getMenuName());
            ticketEntity.setMenuPicture(orderinfoView.getMenuPicture());
            ticketEntity.setPrice(orderinfoView.getTicketPrice());
            ticketEntity.setMealType(orderinfoView.getMealType());
            ticketEntity.setTicketType(TicketType.PAYNOW);
            ticketEntity.setTicketDesc(orderinfoView.getMenuDesc());
            ticketEntity.setTicketDetailDesc(orderinfoView.getMenuDetailDesc());
            ticketEntity.setItemId(orderRequest.getItemId());
            ticketEntity.setItemCount(orderinfoView.getItemBundleCount());
            this.ticketService.add(ticketEntity);
        }

        orderResponse.setStatus("200");
        orderResponse.setError("success");
        orderResponse.setOrderEntities(orderEntities);

        return ResponseEntity.ok(orderResponse);
    }

    @GetMapping("/having")
    public ResponseEntity<OrderResponse> orderHaving(@RequestParam String email) {
        List<OrderEntity> orderEntities = this.orderService.searchAll();

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setStatus("200");
        orderResponse.setError("success");
        orderResponse.setOrderEntities(orderEntities);

        return ResponseEntity.ok(orderResponse);
    }

}

package com.haksik.haksikapi.order.service;

import com.haksik.haksikapi.order.model.OrderEntity;
import com.haksik.haksikapi.order.model.OrderRequest;
import com.haksik.haksikapi.order.model.OrderinfoView;
import com.haksik.haksikapi.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public OrderEntity add(OrderRequest orderRequest) {
        OrderEntity orderEntity = new OrderEntity();

        orderEntity.setUserId(orderRequest.getUserId());
        orderEntity.setCreditcardId(orderRequest.getCreditcardId());
        orderEntity.setItemId(orderRequest.getItemId());
        orderEntity.setItemCount(orderRequest.getItemCount());
        orderEntity.setPaidPrice(orderRequest.getPaidPrice());
        orderEntity.setPaidPoint(orderRequest.getPaidPoint());

        return this.orderRepository.save(orderEntity);
    }

    public List<OrderEntity> searchAll() { return this.orderRepository.findAll(); }

    public OrderinfoView searchOrderInfo(Long itemId) { return this.orderRepository.findOrderInfo(itemId); }

}

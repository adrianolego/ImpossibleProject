package com.e_commerce.mvp.service;

import com.e_commerce.mvp.entity.OrderEntity;
import com.e_commerce.mvp.repository.OrderRepository;
import com.e_commerce.mvp.request.OrderRequest;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderEntity create(OrderRequest request) {
        OrderEntity entity = new OrderEntity();
        entity.setCustomerName(request.customerName());
        entity.setCustomerEmail(request.customerEmail());
        entity.setCustomerPhone(request.customerPhone());
        entity.setTotalAmount(request.totalAmount());
        entity.setStatus(request.status());

        return orderRepository.save(entity);
    }
}

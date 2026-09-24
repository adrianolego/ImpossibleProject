package com.e_commerce.order.service;

import com.e_commerce.order.client.EmailClient;
import com.e_commerce.order.client.SmsClient;
import com.e_commerce.order.entity.OrderEntity;
import com.e_commerce.order.repository.OrderRepository;
import com.e_commerce.order.request.OrderRequest;
import com.e_commerce.order.response.OrderResponse;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class OrderService {

    private static final Logger log =
            LoggerFactory.getLogger(OrderService.class);

    private final OrderRepository orderRepository;
    private final EmailClient emailClient;
    private final SmsClient smsClient;

    public OrderService(OrderRepository orderRepository, EmailClient emailClient, SmsClient smsClient) {
        this.orderRepository = orderRepository;
        this.emailClient = emailClient;
        this.smsClient = smsClient;
    }

    public Long create(OrderRequest request) {

        log.info("Receives the order data and saves it");
        OrderEntity entity = new OrderEntity();
        entity.setCustomerName(request.customerName());
        entity.setCustomerEmail(request.customerEmail());
        entity.setCustomerPhone(request.customerPhone());
        entity.setTotalAmount(request.totalAmount());
        entity.setStatus(request.status());

        log.info("Saving order data");
        var orderEntity = orderRepository.save(entity);

        if (orderEntity.getId() == null) {
            throw new EntityNotFoundException("Order id not found");
        }

        if (orderEntity.getCustomerEmail() != null) {
            log.info("Sending email to customer");
            emailClient.sendEmail(orderEntity.getId());
        }

        if (orderEntity.getCustomerPhone() != null) {
            log.info("Sending sms to customer");
            smsClient.sendSms(orderEntity.getId());
        }
        return orderEntity.getId();
    }

    public OrderResponse find(Long id) {
        log.info("Consultando pedido. orderId={}", id);
        return orderRepository.findById(id)
                .map(order -> {
                    log.debug("Pedido encontrado. orderId={}", id);
                    var response = new OrderResponse();
                    response.setId(order.getId());
                    response.setCustomerName(order.getCustomerName());
                    response.setStatus(order.getStatus());
                    response.setTotalAmount(order.getTotalAmount());
                    response.setCreatedAt(order.getCreatedAt());
                    return response;
                })
                .orElseThrow(() -> {
                    log.warn("Pedido não encontrado. orderId={}", id);
                    return new EntityNotFoundException("Order not found: " + id);
                });
    }

}

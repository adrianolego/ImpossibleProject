package com.e_commerce.mvp.controller;

import com.e_commerce.mvp.request.OrderRequest;
import com.e_commerce.mvp.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/order")
@Tag(name = "Orders", description = "Order Operations")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    @Operation(summary = "Create an order", description = "Receives the order data and saves it")
    public ResponseEntity<Void> saveOrder(@RequestBody @Valid OrderRequest orderRequest) {
        orderService.create(orderRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

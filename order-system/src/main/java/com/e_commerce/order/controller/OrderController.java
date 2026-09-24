package com.e_commerce.order.controller;

import com.e_commerce.order.request.OrderRequest;
import com.e_commerce.order.response.OrderResponse;
import com.e_commerce.order.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping("/v1/order")
@Tag(name = "Orders", description = "Order Operations")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    @Operation(summary = "Create an order", description = "Receives the order data and saves it")
    public ResponseEntity<Long> saveOrder(@RequestBody @Valid OrderRequest orderRequest) {
        return ResponseEntity.ok(orderService.create(orderRequest));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find order", description = "Retrieve orders")
    public ResponseEntity<OrderResponse> getOrder(@PathVariable @Positive Long id) {
        return ResponseEntity.ok(orderService.find(id));
    }
}

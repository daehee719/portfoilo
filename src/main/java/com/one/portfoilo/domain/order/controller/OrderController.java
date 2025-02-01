package com.one.portfoilo.domain.order.controller;

import com.one.portfoilo.domain.order.dto.OrderCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    @PostMapping()
    public ResponseEntity<?> createOrder(@RequestBody OrderCreateRequest request) {
        LocalDateTime registeredDateTime = LocalDateTime.now();
        return ResponseEntity.ok(orderService.createOrder(request, registeredDateTime));
    }
}

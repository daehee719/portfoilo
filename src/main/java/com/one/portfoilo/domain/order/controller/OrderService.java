package com.one.portfoilo.domain.order.controller;

import com.one.portfoilo.domain.order.Order;
import com.one.portfoilo.domain.order.dto.OrderCreateRequest;
import com.one.portfoilo.domain.order.dto.OrderResponse;
import com.one.portfoilo.domain.order.repository.OrderRepository;
import com.one.portfoilo.domain.product.entity.Product;
import com.one.portfoilo.domain.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public OrderResponse createOrder(OrderCreateRequest request, LocalDateTime registeredDateTime) {
        List<String> productNumbers = request.getProductNumbers();

        List<Product> products = productRepository.findByProductNumberIn(productNumbers);

        Order order = Order.create(products, registeredDateTime);
        Order savedOrder = orderRepository.save(order);
        return OrderResponse.of(savedOrder);
    }
}

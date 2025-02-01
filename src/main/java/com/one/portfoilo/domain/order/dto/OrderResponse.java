package com.one.portfoilo.domain.order.dto;

import com.one.portfoilo.domain.order.Order;
import com.one.portfoilo.domain.product.dto.ProductResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@Builder
public class OrderResponse {
    private Long id;
    private int totalPrice;
    private LocalDateTime registeredDateTime;
    private List<ProductResponse> products;

    public static OrderResponse of(Order order) {
        return OrderResponse.builder()
                .id(order.getId())
                .totalPrice(order.getTotalPrice())
                .registeredDateTime(order.getRegisteredDateTime())
                .products(order.getOrderProducts().stream()
                        .map(orderProduct -> ProductResponse.of(orderProduct.getProduct()))
                        .collect(Collectors.toList())
                )
                .build();
    }
}

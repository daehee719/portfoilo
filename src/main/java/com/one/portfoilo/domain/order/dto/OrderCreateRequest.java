package com.one.portfoilo.domain.order.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class OrderCreateRequest {
    private List<String> productNumbers;

    @Builder
    private OrderCreateRequest(List<String> productNumbers) {
        this.productNumbers = productNumbers;
    }
}

package com.one.portfoilo.domain.product;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import org.springframework.security.core.parameters.P;

@Getter
@Builder
public class ProductResponse {
    private Long id;
    private int price;
    private String name;
    private ProductType type;
    private ProductSellingType sellingType;

    public static ProductResponse of(Product product)
    {
        return ProductResponse.builder()
                .id(product.getId())
                .price(product.getPrice())
                .name(product.getName())
                .type(product.getType())
                .sellingType(product.getSellingType())
                .build();
    }

}

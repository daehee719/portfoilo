package com.one.portfoilo.domain.product.dto;

import com.one.portfoilo.domain.product.entity.Product;
import com.one.portfoilo.domain.product.type.ProductSellingStatus;
import com.one.portfoilo.domain.product.type.ProductType;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductResponse {
    private Long id;
    private int price;
    private String name;
    private ProductType type;
    private ProductSellingStatus sellingType;

    public static ProductResponse of(Product product)
    {
        return ProductResponse.builder()
                .id(product.getId())
                .price(product.getPrice())
                .name(product.getName())
                .type(product.getType())
                .sellingType(product.getSellingStatus())
                .build();
    }

}

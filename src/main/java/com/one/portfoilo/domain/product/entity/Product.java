package com.one.portfoilo.domain.product.entity;

import com.one.portfoilo.domain.base.BaseEntity;
import com.one.portfoilo.domain.product.type.ProductSellingStatus;
import com.one.portfoilo.domain.product.type.ProductType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@Getter @Setter
@Builder
@AllArgsConstructor
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productNumber;

    private int price;

    private String name;

    @Enumerated(EnumType.STRING)
    private ProductType type;

    @Enumerated(EnumType.STRING)
    private ProductSellingStatus sellingStatus;

}

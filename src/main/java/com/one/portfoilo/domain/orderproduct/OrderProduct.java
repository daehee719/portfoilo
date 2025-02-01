package com.one.portfoilo.domain.orderproduct;

import com.one.portfoilo.domain.base.BaseEntity;
import com.one.portfoilo.domain.order.Order;
import com.one.portfoilo.domain.product.entity.Product;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@RequiredArgsConstructor
public class OrderProduct extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;


    public OrderProduct(Order order, Product product) {
        this.order = order;
        this.product = product;
    }
}

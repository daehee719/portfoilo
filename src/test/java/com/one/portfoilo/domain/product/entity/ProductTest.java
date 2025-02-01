package com.one.portfoilo.domain.product.entity;

import com.one.portfoilo.domain.product.type.ProductSellingStatus;
import com.one.portfoilo.domain.product.type.ProductType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    private Product product;

    @BeforeEach
    void setUp() {
        product = Product.builder()
                .name("뉴서울아파트")
                .price(4000)
                .type(ProductType.MONTHLY_RENT)
                .sellingStatus(ProductSellingStatus.SELLING)
                .build();
    }

    @Test
    @DisplayName("프로덕트의 가격을 0으로 설정해서 예외를 처리한다.")
    void setPriceZero()
    {
//        assertThatThrownBy(() -> product.setPrice(0))
//                .isInstanceOf(IllegalArgumentException.class);
////        product.setPrice(0);
//        assertThat(product.getPrice())
////                .isBetween(1, Integer.MAX_VALUE)
//                .hasNoNullFieldsOrPropertiesExcept(null, "price");
    }


    @Test
    @DisplayName("프로덕트의 가격을 가져온다.")
    void getPrice() {
        assertThat(product.getPrice()).isEqualTo(4000);
    }

    @Test
    void getName() {
    }

    @Test
    void getType() {
    }

    @Test
    void getSellingStatus() {
    }

    @Test
    void builder() {
    }
}
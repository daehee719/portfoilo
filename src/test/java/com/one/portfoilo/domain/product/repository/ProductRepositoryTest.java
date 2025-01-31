package com.one.portfoilo.domain.product.repository;

import com.one.portfoilo.domain.product.entity.Product;
import com.one.portfoilo.domain.product.type.ProductSellingStatus;
import com.one.portfoilo.domain.product.type.ProductType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static com.one.portfoilo.domain.product.type.ProductSellingStatus.*;
import static com.one.portfoilo.domain.product.type.ProductType.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.tuple;
import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @DisplayName("원하는 판매상태를 가진 상품들을 반환한다.")
    @Test
    void findAllBySellingStatusIn()
    {
        // given
        Product product1 = Product.builder()
                .name("건영아파트")
                .price(4000)
                .type(JEOUNSE)
                .sellingStatus(SELLING)
                .build();

        Product product2 = Product.builder()
                .name("뉴서울아파트")
                .price(4000)
                .type(JEOUNSE)
                .sellingStatus(HOLD)
                .build();

        productRepository.saveAll(List.of(product1, product2));

        // when
        List<Product> products = productRepository.findBySellingStatusIn(List.of(SELLING,HOLD));

        // then
        assertThat(products).hasSize(2)
                .extracting("name", "price", "type", "sellingStatus")
                        .containsExactlyInAnyOrder(
                                tuple("건영아파트", 4000, JEOUNSE, SELLING),
                                tuple("뉴서울아파트", 4000, JEOUNSE, HOLD)
                        );
    }
}
package com.one.portfoilo.domain.product.repository;

import com.one.portfoilo.domain.product.entity.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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

    @AfterEach
    void tearDown() {
        productRepository.deleteAllInBatch();
    }

    @DisplayName("원하는 판매상태를 가진 상품들을 반환한다.")
    @Test
    void findAllBySellingStatusIn()
    {
        // given
        Product product1 = Product.builder()
                .productNumber("001")
                .name("건영아파트")
                .price(4000)
                .type(JEOUNSE)
                .sellingStatus(SELLING)
                .build();

        Product product2 = Product.builder()
                .productNumber("002")
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

    @DisplayName("상품번호 리스트로 상품들을 조회한다.")
    @Test
    void findByProductNumberIn() {
        // given
        Product product1 = Product.builder()
                .productNumber("001")
                .name("건영아파트")
                .price(4000)
                .type(JEOUNSE)
                .sellingStatus(SELLING)
                .build();

        Product product2 = Product.builder()
                .productNumber("002")
                .name("뉴서울아파트")
                .price(4000)
                .type(JEOUNSE)
                .sellingStatus(HOLD)
                .build();

        productRepository.saveAll(List.of(product1, product2));

        // when
        List<Product> products = productRepository.findByProductNumberIn(List.of("001", "002"));

        // then
        assertThat(products).hasSize(2)
                .extracting("productNumber", "name", "sellingStatus")
                .containsExactlyInAnyOrder(
                        tuple("001", "건영아파트", SELLING),
                        tuple("002", "뉴서울아파트", HOLD)
                );
    }
}
package com.one.portfoilo.domain.order;

import com.one.portfoilo.domain.order.controller.OrderService;
import com.one.portfoilo.domain.order.dto.OrderCreateRequest;
import com.one.portfoilo.domain.order.dto.OrderResponse;
import com.one.portfoilo.domain.order.repository.OrderRepository;
import com.one.portfoilo.domain.orderproduct.OrderProductRepository;
import com.one.portfoilo.domain.product.entity.Product;
import com.one.portfoilo.domain.product.repository.ProductRepository;
import com.one.portfoilo.domain.product.type.ProductType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.List;

import static com.one.portfoilo.domain.product.type.ProductSellingStatus.SELLING;
import static com.one.portfoilo.domain.product.type.ProductType.JEOUNSE;
import static com.one.portfoilo.domain.product.type.ProductType.MONTHLY_RENT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

@ActiveProfiles("test")
@SpringBootTest
class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderProductRepository orderProductRepository;

    @AfterEach
    void tearDown() {
        orderProductRepository.deleteAllInBatch();
        productRepository.deleteAllInBatch();
        orderRepository.deleteAllInBatch();
    }

    @DisplayName("주문번호 리스트를 받아 주문을 생성한다.")
    @Test
    void createOrder()
    {
        // given
        LocalDateTime registeredDateTime = LocalDateTime.now();

        Product product1 = createProduct(JEOUNSE, "001", 4000);
        Product product2 = createProduct(MONTHLY_RENT, "002", 5000);

        // when
        productRepository.saveAll(List.of(product1, product2));

        OrderCreateRequest request = OrderCreateRequest.builder()
                .productNumbers(List.of("001","002"))
                .build();
        OrderResponse orderResponse = orderService.createOrder(request, registeredDateTime);

        //then
        assertThat(orderResponse.getId()).isNotNull();

        assertThat(orderResponse)
                .extracting("registeredDateTime", "totalPrice")
                .contains(registeredDateTime, 9000);

        assertThat(orderResponse.getProducts()).hasSize(2)
                .extracting("productNumber", "price")
                .containsExactlyInAnyOrder(
                        tuple("001", 4000),
                        tuple("002", 5000)
                );
    }

    private Product createProduct(ProductType type, String productNumber, int price)
    {
        return Product.builder()
                .type(type)
                .productNumber(productNumber)
                .price(price)
                .sellingStatus(SELLING)
                .name("건영아파트")
                .build();
    }
}
package com.one.portfoilo.domain.product.service;

import com.one.portfoilo.domain.product.dto.ProductResponse;
import com.one.portfoilo.domain.product.entity.Product;
import com.one.portfoilo.domain.product.repository.ProductRepository;
import com.one.portfoilo.domain.product.type.ProductSellingStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<ProductResponse> getSellingProducts()
    {
        List<Product> products = productRepository.findBySellingStatusIn(ProductSellingStatus.forDisplay());

        return products.stream()
                .map(ProductResponse::of)
                .collect(Collectors.toList());
    }
}

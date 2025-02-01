package com.one.portfoilo.domain.product.repository;

import com.one.portfoilo.domain.product.entity.Product;
import com.one.portfoilo.domain.product.type.ProductSellingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findBySellingStatusIn(List<ProductSellingStatus> sellingStatuses);

    List<Product> findByProductNumberIn(List<String> productNumbers);
}

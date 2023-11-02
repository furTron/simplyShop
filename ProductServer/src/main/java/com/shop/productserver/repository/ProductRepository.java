package com.shop.productserver.repository;

import com.shop.productserver.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllBySellNumber(int sellNumber);

    Product findFirstBySellNumberAndStatusEquals(int sellNumber, Product.Status status);

    List<Product> findAllByStatusIsNull();
}

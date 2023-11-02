package com.shop.productserver.service;

import com.shop.productserver.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getAllProducts();

    Product getProduct(int sellNumber);

    Product addProduct(Optional<Product> input);

    Product removeProduct(int sellNumber);
}

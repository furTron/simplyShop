package com.shop.productserver.service;

import com.shop.productserver.exception.ProductError;
import com.shop.productserver.exception.ProductException;
import com.shop.productserver.model.Product;
import com.shop.productserver.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(int sellNumber) {
        Product tmp = productRepository.findFirstBySellNumberAndStatusEquals(sellNumber, Product.Status.ACTIVE);
        if (tmp == null) throw new ProductException(ProductError.PRODUCT_NOT_FOUND);
        return tmp;
    }

    @Override
    public Product removeProduct(int sellNumber) {
        Product tmp = productRepository.findFirstBySellNumberAndStatusEquals(sellNumber, Product.Status.ACTIVE);
        if (tmp != null) {
            tmp.setInactive();
            productRepository.save(tmp);
        }
        return tmp;
    }

    @Override
    public Product addProduct(Optional<Product> input) {
        if (input.isEmpty()) throw new ProductException(ProductError.PRODUCT_NOT_CORRECT);
        Product newProduct = input.get();

        if (!newProduct.testProduct()) throw new ProductException(ProductError.PRODUCT_NOT_CORRECT);

        removeProduct(newProduct.getSellNumber());
        newProduct.setActive();
        return productRepository.save(newProduct);
    }
}

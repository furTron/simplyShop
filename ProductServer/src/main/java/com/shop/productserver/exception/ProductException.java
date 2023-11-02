package com.shop.productserver.exception;

public class ProductException extends RuntimeException{
    private final ProductError productError;

    public ProductError getProductError() {
        return productError;
    }

    public ProductException(ProductError productError) {
        this.productError = productError;
    }
}

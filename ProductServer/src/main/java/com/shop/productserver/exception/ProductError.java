package com.shop.productserver.exception;

public enum ProductError {

    PRODUCT_NOT_FOUND("Product has not been found"),
    PRODUCT_NOT_CORRECT("Product's parameters dont match requirements");
    private String message = "Unknown error!";

    public String getMessage() {
        return message;
    }

    ProductError(String message) {
        this.message = message;
    }
}

package com.shop.productserver.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductExceptionHandler {

    @ExceptionHandler(value = ProductException.class)
    public ResponseEntity<RequestMessage> handleException(ProductException e){
//        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
//
//        if (ProductError.PRODUCT_NOT_FOUND.equals(e.getProductError()))
//            httpStatus = HttpStatus.NOT_FOUND;
//
//        if (ProductError.PRODUCT_NOT_CORRECT.equals(e.getProductError()))
//            httpStatus = HttpStatus.BAD_REQUEST;

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(new RequestMessage(e.getProductError().getMessage()));
    }
}

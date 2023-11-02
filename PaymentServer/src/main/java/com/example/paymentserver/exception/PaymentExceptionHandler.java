package com.example.paymentserver.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PaymentExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<RequestMessage> handleException(PaymentException e){
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(new RequestMessage(e.getPaymentError().getMessage()));
    }
}

package com.example.cashregister.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CashRegisterExceptionHandler {

    @ExceptionHandler(value = CashRegisterException.class)
    public ResponseEntity<RequestMessage> handleException(CashRegisterException e){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new RequestMessage(e.getCashRegisterError().getMessage()));
    }

    @ExceptionHandler(value = FeignResponseException.class)
    public ResponseEntity<RequestMessage> feignHandleException(FeignResponseException e){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new RequestMessage(e.getResponse()));
    }
}

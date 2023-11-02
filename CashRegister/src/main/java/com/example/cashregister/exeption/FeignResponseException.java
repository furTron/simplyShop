package com.example.cashregister.exeption;

public class FeignResponseException extends RuntimeException{

    private final String response;

    public String getResponse() {
        return response;
    }

    public FeignResponseException(String message) {
        this.response = message;
    }
}

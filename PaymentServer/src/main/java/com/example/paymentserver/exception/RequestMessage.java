package com.example.paymentserver.exception;

public class RequestMessage {

    final private String message;

    public String getMessage() {
        return message;
    }

    public RequestMessage(String message) {
        this.message = message;
    }
}

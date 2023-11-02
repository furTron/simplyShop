package com.example.paymentserver.exception;

public enum PaymentError {

    INPUT_DATA_EMPTY("No input data"),
    CARD_NUMBER_WRONG("Incorrect card number"),
    DUE_AMOUNT_WRONG("Incorrect payment amount");

    private String message = "Unknown error!";

    public String getMessage(){
        return message;
    }

    PaymentError(String message) {
        this.message = message;
    }
}

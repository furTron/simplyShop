package com.example.cashregister.exeption;

public enum CashRegisterError {

    NO_INPUT("Your request does not contain required parameters"),
    WRONG_PRODUCT_NUMBER("Product's number is incorrect"),
    WRONG_CARD_NUMBER("Card's number is incorrect"),
    NO_RESPONSE_FROM_PAYMENT_SERVER("Payment Server does not respond"),
    NO_RESPONSE_FROM_PRODUCT_SERVER("Product Server does not respond"),
    INCORRECT_INPUT_FROM_PAYMENT_SERVER("Corrupted response from Payment Server"),
    INCORRECT_INPUT_FROM_PRODUCT_SERVER("Corrupted response from Product Server"),
    PAYMENT_REJECTED("Payment has been rejected by your Bank"),
    PAYMENT_ALREADY_PRESENT("Bill has been already paid");

    private String message = "Unknown error!";

    public String getMessage(){
        return message;
    }

    CashRegisterError(String message) {
        this.message = message;
    }
}

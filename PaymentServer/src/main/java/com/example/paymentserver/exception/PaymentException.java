package com.example.paymentserver.exception;

public class PaymentException extends RuntimeException{

    private final PaymentError paymentError;

    public PaymentError getPaymentError() {
        return paymentError;
    }

    public PaymentException(PaymentError paymentError) {
        this.paymentError = paymentError;
    }
}

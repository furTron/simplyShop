package com.example.cashregister.model.dto;

import lombok.Getter;

@Getter
public class PaymentInput {

    private long creditCardNumber;
    private double dueAmount;

    public PaymentInput(long creditCardNumber, double dueAmount) {
        this.creditCardNumber = creditCardNumber;
        this.dueAmount = dueAmount;
    }
}
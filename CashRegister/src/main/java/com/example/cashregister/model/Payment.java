package com.example.cashregister.model;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Payment {

    private final Long paymentId;
    private final LocalDateTime dateTime;

    public Payment(long paymentId) {
        this.paymentId = paymentId;
        this.dateTime = LocalDateTime.now();
    }
}

package com.example.cashregister.model.dto;

import lombok.Getter;

@Getter
public class PaymentOutput {
    public enum Status {
        ACCEPTED,
        REJECTED;
    }

    private Status status;
    private Long paymentId;
    private String message;

    public PaymentOutput(Status status, Long paymentId) {
        this.status = status;
        this.paymentId = paymentId;
    }
}

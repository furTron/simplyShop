package com.example.paymentserver.model.dto;

import lombok.Getter;

@Getter
public class ResponseData {
    public enum Status {
        ACCEPTED,
        REJECTED;
    }

    private Status status = Status.REJECTED;
    private long paymentId;

    public ResponseData(Status status, long paymentId) {
        this.status = status;
        this.paymentId = paymentId;
    }
}

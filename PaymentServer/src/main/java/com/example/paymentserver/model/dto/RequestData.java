package com.example.paymentserver.model.dto;

import lombok.Getter;

@Getter
public class RequestData {
    private Long creditCardNumber;
    private Double dueAmount;
}

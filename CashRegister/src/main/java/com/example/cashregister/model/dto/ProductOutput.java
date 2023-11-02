package com.example.cashregister.model.dto;

import lombok.Getter;

@Getter
public class ProductOutput {

    private Long sellNumber;

    private String name;

    private Double price;

    private String message;

    public ProductOutput(long sellNumber, String name, double price) {
        this.sellNumber = sellNumber;
        this.name = name;
        this.price = price;
    }
}

package com.example.cashregister.model;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
public class Product {

    private final long sellNumber;

    private final String name;

    private final double price;

    private long amount;

    public Product(long sellNumber, String name, double price) {
        this.sellNumber = sellNumber;
        this.name = name;
        this.price = price;
        this.amount = 1;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
}

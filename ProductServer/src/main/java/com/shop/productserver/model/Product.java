package com.shop.productserver.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@SequenceGenerator(name = "myGenerator", initialValue = 1000, allocationSize = 1)
@Entity
public class Product {

    public enum Status {
        ACTIVE,
        INACTIVE;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "myGenerator")
    private long ID;

    private int sellNumber;

    private String name;

    private double price;

    private Status status;

    public void setInactive() {
        status = Status.INACTIVE;
    }

    public void setActive() {
        status = Status.ACTIVE;
    }

    public boolean testProduct() {

        if (sellNumber < 100_000_000
                || sellNumber > 999_999_999) return false;

        if (name == null || name.isBlank()) return false;

        if (price < 0) return false;

        return true;
    }
}


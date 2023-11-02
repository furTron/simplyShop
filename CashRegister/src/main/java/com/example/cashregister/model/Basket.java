package com.example.cashregister.model;

import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Getter
@Setter
@Component
public class Basket {
    private Map<Long, Product> listOfProducts;
    private double totalDue;
    Payment payment;

    public Basket() {
        this.listOfProducts = new HashMap<>();
        totalDue = 0;
    }


    public Basket showBasket() {
        return this;
    }


    public Basket addProductToBasket(Product product) {
        if (this.payment != null)
            dropBasket();

        if (listOfProducts.containsKey(product.getSellNumber()))
            product.setAmount(1 + listOfProducts.get(product.getSellNumber()).getAmount());

        listOfProducts.put(product.getSellNumber(), product);
        totalDue += product.getPrice();

        return showBasket();
    }


    public Basket dropBasket() {
        listOfProducts.clear();
        totalDue = 0;
        payment = null;
        return showBasket();
    }


    public Basket addPayment(Payment payment) {
        this.payment = payment;
        return showBasket();
    }
}

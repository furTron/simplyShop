package com.example.cashregister.service;

import com.example.cashregister.model.Basket;
import com.example.cashregister.model.Product;

public interface CashRegisterService {

    public Basket showBasket();

    public Product showProduct(Long productNumber);

    public Basket addToBasket(Long productNumber);

    public Basket payForBasket(Long creditCardNumber);
}

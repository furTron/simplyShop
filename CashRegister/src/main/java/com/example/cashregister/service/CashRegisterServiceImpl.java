package com.example.cashregister.service;

import com.example.cashregister.exeption.CashRegisterError;
import com.example.cashregister.exeption.CashRegisterException;
import com.example.cashregister.model.Basket;
import com.example.cashregister.model.Product;
import org.springframework.stereotype.Service;

@Service
public class CashRegisterServiceImpl implements CashRegisterService {


    private final Basket basket;
    private final ProductService productService;
    private final PaymentService paymentService;

    public CashRegisterServiceImpl(Basket basket, ProductService productService, PaymentService paymentService) {
        this.basket = basket;
        this.productService = productService;
        this.paymentService = paymentService;
    }

    @Override
    public Basket showBasket() {
        return basket.showBasket();
    }

    @Override
    public Product showProduct(Long productNumber) {
        if (productNumber == null) throw new CashRegisterException(CashRegisterError.NO_INPUT);
        productService.checkProductNumber(productNumber);
        return productService.getProduct(productNumber);
    }

    @Override
    public Basket addToBasket(Long productNumber) {
        if (productNumber == null) throw new CashRegisterException(CashRegisterError.NO_INPUT);
        productService.checkProductNumber(productNumber);
        return basket.addProductToBasket(productService.getProduct(productNumber));
    }

    @Override
    public Basket payForBasket(Long creditCardNumber) {
        if (creditCardNumber == null) throw new CashRegisterException(CashRegisterError.NO_INPUT);
        if (basket.getPayment() != null) throw new CashRegisterException(CashRegisterError.PAYMENT_ALREADY_PRESENT);
        paymentService.checkCreditCardNumber(creditCardNumber);
        return basket.addPayment(paymentService.getPayment(creditCardNumber, basket.getTotalDue()));
    }
}

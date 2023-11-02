package com.example.cashregister.controller;

import com.example.cashregister.model.Basket;
import com.example.cashregister.model.Product;
import com.example.cashregister.service.CashRegisterServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    private final CashRegisterServiceImpl cashRegisterService;

    public Controller(CashRegisterServiceImpl cashRegisterService) {
        this.cashRegisterService = cashRegisterService;
    }

    @GetMapping
    public Basket showBasket(){
        return cashRegisterService.showBasket();
    }

    @GetMapping("/{id}")
    public Product showProduct(@PathVariable Long id){
        return cashRegisterService.showProduct(id);
    }

    @PostMapping("/{id}")
    public Basket addToBasket(@PathVariable Long id){
        return cashRegisterService.addToBasket(id);
    }

    @PostMapping("/pay")
    public Basket pay(@RequestParam Long cardNumber){
        return cashRegisterService.payForBasket(cardNumber);
    }
}

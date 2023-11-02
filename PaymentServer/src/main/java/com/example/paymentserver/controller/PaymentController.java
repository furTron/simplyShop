package com.example.paymentserver.controller;

import com.example.paymentserver.model.Payment;
import com.example.paymentserver.model.dto.RequestData;
import com.example.paymentserver.model.dto.ResponseData;
import com.example.paymentserver.service.PaymentServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PaymentController {

    private final PaymentServiceImpl paymentService;

    public PaymentController(PaymentServiceImpl paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping
    public List<Payment> getAllPayments(){
        return paymentService.getAllPayments();
    }

    @PostMapping
    public ResponseData makePayment(@RequestBody Optional<RequestData> requestData){
        return paymentService.makePayment(requestData);
    }
}

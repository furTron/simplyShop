package com.example.cashregister.service;

import com.example.cashregister.model.dto.PaymentOutput;
import com.example.cashregister.model.dto.PaymentInput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@FeignClient(name = "PAYMENT-SERVICE")
public interface PaymentServiceClient {

    @PostMapping()
    public Optional<PaymentOutput> getPayment(@RequestBody PaymentInput paymentInput);
}

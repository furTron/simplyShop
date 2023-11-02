package com.example.paymentserver.service;

import com.example.paymentserver.model.Payment;
import com.example.paymentserver.model.dto.RequestData;
import com.example.paymentserver.model.dto.ResponseData;

import java.util.List;
import java.util.Optional;

public interface PaymentService {

    public List<Payment> getAllPayments();

    public ResponseData makePayment(Optional<RequestData> input);
}

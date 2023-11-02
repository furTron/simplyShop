package com.example.paymentserver.service;

import com.example.paymentserver.exception.PaymentError;
import com.example.paymentserver.exception.PaymentException;
import com.example.paymentserver.model.Payment;
import com.example.paymentserver.model.dto.RequestData;
import com.example.paymentserver.model.dto.ResponseData;
import com.example.paymentserver.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }


    @Override
    public ResponseData makePayment(Optional<RequestData> input) {
        if (input.isEmpty()) throw new PaymentException(PaymentError.INPUT_DATA_EMPTY);
        RequestData requestData = input.get();

        if (requestData.getCreditCardNumber() == null) throw new PaymentException(PaymentError.INPUT_DATA_EMPTY);
        if (requestData.getDueAmount() == null) throw new PaymentException(PaymentError.INPUT_DATA_EMPTY);

        Payment payment = new Payment();
        payment.pay(requestData.getCreditCardNumber(), requestData.getDueAmount());
        paymentRepository.save(payment);
        return payment.response();
    }
}

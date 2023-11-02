package com.example.cashregister.service;

import com.example.cashregister.exeption.CashRegisterError;
import com.example.cashregister.exeption.CashRegisterException;
import com.example.cashregister.exeption.FeignResponseException;
import com.example.cashregister.model.Payment;
import com.example.cashregister.model.dto.PaymentInput;
import com.example.cashregister.model.dto.PaymentOutput;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentService {

    private final PaymentServiceClient paymentServiceClient;

    public PaymentService(PaymentServiceClient paymentServiceClient) {
        this.paymentServiceClient = paymentServiceClient;
    }


    public Payment getPayment(long creditCardNumber, double dueAmount){
        Optional<PaymentOutput> output =
                paymentServiceClient.getPayment(new PaymentInput(creditCardNumber, dueAmount));
        if (output.isEmpty()) throw new CashRegisterException(CashRegisterError.NO_RESPONSE_FROM_PAYMENT_SERVER);
        if (output.get().getMessage() != null) throw new FeignResponseException(output.get().getMessage());

        PaymentOutput paymentOutput = output.get();
        if (paymentOutput.getPaymentId() == null) throw new CashRegisterException(CashRegisterError.INCORRECT_INPUT_FROM_PAYMENT_SERVER);
        if (paymentOutput.getStatus() == null) throw new CashRegisterException(CashRegisterError.INCORRECT_INPUT_FROM_PAYMENT_SERVER);
        if (paymentOutput.getStatus() == PaymentOutput.Status.REJECTED) throw new CashRegisterException(CashRegisterError.PAYMENT_REJECTED);
        return new Payment(paymentOutput.getPaymentId());
    }

    public void checkCreditCardNumber(long numberToCheck) {
        if (numberToCheck > 9999_9999_9999_9999L) throw new CashRegisterException(CashRegisterError.WRONG_CARD_NUMBER);
        if (numberToCheck < 1000_0000_0000_0000L) throw new CashRegisterException(CashRegisterError.WRONG_CARD_NUMBER);
        if (numberToCheck % 2 != 0) throw new CashRegisterException(CashRegisterError.WRONG_CARD_NUMBER);
    }
}

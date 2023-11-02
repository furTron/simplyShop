package com.example.paymentserver.model;

import com.example.paymentserver.exception.PaymentException;
import com.example.paymentserver.model.dto.ResponseData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentTest {

    @Test
    void testWrongDueAmount() {

        // this one should be Accepted
        Payment payment = new Payment();
        payment.pay(1234_1234_1234_1204L, 9.99);
        assertEquals(ResponseData.Status.ACCEPTED, payment.response().getStatus());

        // this one should be Accepted
        payment = new Payment();
        payment.pay(1234_1234_1234_1204L, 0.01);
        assertEquals(ResponseData.Status.ACCEPTED, payment.response().getStatus());


        // this one should throw an exception
        assertThrows(PaymentException.class, () -> {
            Payment tmp = new Payment();
            tmp.pay(1234_1234_1234_1204L, 0);
        });

        // this one should throw an exception
        assertThrows(PaymentException.class, () -> {
            Payment tmp = new Payment();
            tmp.pay(1234_1234_1234_1204L, -1);
        });
    }

    @Test
    void testIncorrectCardNumber() {

        // this one should be Accepted
        Payment payment = new Payment();
        payment.pay(1234_1234_1234_1204L, 9.99);
        assertEquals(ResponseData.Status.ACCEPTED, payment.response().getStatus());


        // this one should throw an exception (too long number)
        assertThrows(PaymentException.class, () -> {
            Payment tmp = new Payment();
            tmp.pay(1234_1234_1234_1204_04L, 9.99);
        });

        // this one should throw an exception (too short number)
        assertThrows(PaymentException.class, () -> {
            Payment tmp = new Payment();
            tmp.pay(1234_1234_1234_04L, 9.99);
        });


        // this one should throw an exception (incorrect number)
        assertThrows(PaymentException.class, () -> {
            Payment tmp = new Payment();
            tmp.pay(1234_1234_1234_1201L, 9.99);
        });


        payment = new Payment();  //  should be "rejected by bank"
        payment.pay(1234_1234_1234_1202L, 9.99);
        assertEquals(ResponseData.Status.REJECTED, payment.response().getStatus());
    }
}
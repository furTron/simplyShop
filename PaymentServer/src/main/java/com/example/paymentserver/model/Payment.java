package com.example.paymentserver.model;

import com.example.paymentserver.exception.PaymentError;
import com.example.paymentserver.exception.PaymentException;
import com.example.paymentserver.model.dto.ResponseData;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@SequenceGenerator(name = "myGenerator", initialValue = 1000, allocationSize = 1)
@Getter
@Entity
public class Payment {
    enum Status {
        ACCEPTED,
        REJECTED;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "myGenerator")
    private long transactionId;
    private double dueAmount;
    private long creditCardNumber;
    private LocalDateTime paymentDate;
    private Status status = Status.REJECTED;

    public ResponseData response() {
        if (Status.ACCEPTED.equals(this.status))
        return new ResponseData(ResponseData.Status.ACCEPTED, this.transactionId);
        else return new ResponseData(ResponseData.Status.REJECTED, this.transactionId);
    }

    public void pay(long creditCardNumber, double dueAmount) {
        if (dueAmount <= 0) throw new PaymentException(PaymentError.DUE_AMOUNT_WRONG);
        if (!testCreditCardNumber(creditCardNumber)) throw new PaymentException(PaymentError.CARD_NUMBER_WRONG);

        this.dueAmount = dueAmount;
        this.creditCardNumber = creditCardNumber;
        this.paymentDate = LocalDateTime.now();

        if (proceedPayment(creditCardNumber, dueAmount))
            this.status = Status.ACCEPTED;
        else
            this.status = Status.REJECTED;
    }

    private boolean testCreditCardNumber(long numberToCheck) {
        if (numberToCheck > 9999_9999_9999_9999L) return false;
        if (numberToCheck < 1000_0000_0000_0000L) return false;
        if (numberToCheck % 2 != 0) return false;  // fake sum check
        return true;
    }

    private boolean proceedPayment(long creditCardNumber, double dueAmount) {   // fake connection to a bank
        if (creditCardNumber % 4 == 0) return true;
        else return false;
    }
}

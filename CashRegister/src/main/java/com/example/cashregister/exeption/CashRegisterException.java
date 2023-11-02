package com.example.cashregister.exeption;

public class CashRegisterException extends RuntimeException{

    private final CashRegisterError cashRegisterError;

    public CashRegisterError getCashRegisterError() {
        return cashRegisterError;
    }

    public CashRegisterException(CashRegisterError cashRegisterError) {
        this.cashRegisterError = cashRegisterError;
    }
}

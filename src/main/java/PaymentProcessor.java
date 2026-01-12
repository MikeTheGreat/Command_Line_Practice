package com.example.payment;

public class PaymentProcessor {

    public boolean processPayment(String cardNumber, double amount) {
        // TODO: Implement actual payment logic
        // FIXME: This is a security vulnerability - storing card numbers
        System.out.println("Processing payment: " + amount);
        return true;
    }

    public void refund(String transactionId) {
        // TODO: Implement refund logic
        throw new UnsupportedOperationException("Not implemented yet");
    }
}

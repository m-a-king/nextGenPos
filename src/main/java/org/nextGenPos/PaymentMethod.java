package org.nextGenPos;

public interface PaymentMethod {
    void processPayment(Money amount);
}
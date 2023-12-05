package org.nextGenPos;

import lombok.Getter;

@Getter
public class Payment {
    private final Money amount;
    private final PaymentMethod paymentMethod;

    public Payment(Money amount, PaymentMethod paymentMethod) {
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentMethod.processPayment(amount);
    }
}
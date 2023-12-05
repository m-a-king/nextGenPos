package org.nextGenPos;

public class CashPayment implements PaymentMethod {
    @Override
    public void processPayment(Money amount) {
        System.out.println("Processed cash payment of " + amount.getAmount());
    }
}

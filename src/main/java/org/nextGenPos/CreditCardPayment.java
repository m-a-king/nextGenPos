package org.nextGenPos;

public class CreditCardPayment implements PaymentMethod {
    @Override
    public void processPayment(Money amount) {
        // 카드 결제 처리 로직
        System.out.println("Processed credit card payment of " + amount.getAmount());
    }
}
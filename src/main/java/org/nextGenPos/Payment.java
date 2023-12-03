package org.nextGenPos;

// Class Payment
public class Payment {
    private Money amount;

    public Payment(Money cashTendered) {
        amount = cashTendered;
    }

    public Money getAmount() {
        return amount;
    }
}
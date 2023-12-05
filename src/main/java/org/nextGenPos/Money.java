package org.nextGenPos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Money {
    private final int amount;

    public Money times(int quantity) {
        return new Money(this.amount * quantity);
    }

    public Money add(Money other) {
        return new Money(this.amount + other.amount);
    }

    public Money minus(Money total) {
        return new Money(this.amount - total.amount);
    }
}

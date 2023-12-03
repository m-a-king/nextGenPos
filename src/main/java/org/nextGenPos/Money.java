package org.nextGenPos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Money {
    private int amount = 0;

    public Money times(int quantity) {
        this.amount = this.amount * quantity;
        return this;
    }


    public void add(Money subtotal) {
        this.amount += subtotal.amount;
    }

    public Money minus(Money total) {
        int result = this.amount - total.amount;
        return new Money(result);
    }

}

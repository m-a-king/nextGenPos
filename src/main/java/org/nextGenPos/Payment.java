package org.nextGenPos;

import lombok.Getter;

@Getter
public class Payment {
    private final Money amount;

    public Payment(Money cashTendered) {
        amount = cashTendered;
    }


}
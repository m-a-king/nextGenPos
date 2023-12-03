package org.nextGenPos;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SalesLineItem {
    private final int quantity;
    private final Money price;

    public Money getSubtotal() {
        return this.price.times(quantity);
    }
}
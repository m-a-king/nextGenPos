package org.nextGenPos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class SalesLineItem {
    private final ItemID itemID;
    private final int quantity;
    private final Money price;

    public Money getSubtotal() {
        return this.price.times(quantity);
    }
}
package org.nextGenPos;

import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class ProductCatalog {

    private final Map<ItemID, Money> productSpecifications;

    public ProductCatalog() {
        this.productSpecifications = new HashMap<>();
    }

    public Money getPriceByItemId(ItemID itemId) {
        return productSpecifications.get(itemId);
    }
}
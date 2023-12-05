package org.nextGenPos;

import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@NoArgsConstructor
public class ProductCatalog {
    private final Map<ItemID, ProductSpecification> productSpecifications = new HashMap<>();

    public void addProductSpecification(ItemID itemId, ProductSpecification spec) {
        productSpecifications.put(itemId, spec);
    }

    public Money getPriceByItemId(ItemID itemId) {
        ProductSpecification spec = productSpecifications.get(itemId);
        if (spec == null) {
            throw new NoSuchElementException("ItemID " + itemId + " not found in product catalog.");
        }
        return spec.getPrice();
    }

    public String getDescriptionByItemId(ItemID itemId) {
        ProductSpecification spec = productSpecifications.get(itemId);
        if (spec == null) {
            throw new NoSuchElementException("ItemID " + itemId + " not found in product catalog.");
        }
        return spec.getDescription();
    }
}

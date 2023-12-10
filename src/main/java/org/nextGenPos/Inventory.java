package org.nextGenPos;

import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
public class Inventory {
    private final Map<ItemID, Integer> stockItems = new HashMap<>();

    public void addStock(ItemID itemId, int quantity) {
        this.stockItems.put(itemId, this.stockItems.getOrDefault(itemId, 0) + quantity);
    }

    public void removeStock(ItemID itemId, int quantity) {
        int currentQuantity = this.stockItems.getOrDefault(itemId, 0);
        if (currentQuantity < quantity) {
            throw new IllegalArgumentException("Insufficient stock for ItemID " + itemId);
        }
        this.stockItems.put(itemId, currentQuantity - quantity);
    }

    public int getStockQuantity(ItemID itemId) {
        return this.stockItems.getOrDefault(itemId, 0);
    }
}

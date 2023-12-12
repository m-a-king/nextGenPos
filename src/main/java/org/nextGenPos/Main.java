package org.nextGenPos;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        Register register = store.getRegister();
        ProductCatalog productCatalog = store.getCatalog();
        Inventory inventory = store.getInventory();

        ItemID testItemID1 = new ItemID(1);
        ItemID testItemID2 = new ItemID(2);
        ItemID testItemID3 = new ItemID(3);
        Money testItemPrice1 = new Money(100);
        Money testItemPrice2 = new Money(300);
        Money testItemPrice3 = new Money(400);
        int initialStockQuantity = 10;

        productCatalog.addProductSpecification(testItemID1, new ProductSpecification(testItemPrice1, "Test Product"));
        productCatalog.addProductSpecification(testItemID2, new ProductSpecification(testItemPrice2, "Test Product"));
        productCatalog.addProductSpecification(testItemID3, new ProductSpecification(testItemPrice3, "Test Product"));
        inventory.addStock(testItemID1, initialStockQuantity);
        inventory.addStock(testItemID2, initialStockQuantity);
        inventory.addStock(testItemID3, initialStockQuantity);

        register.makeNewSale();

        register.enterItem(testItemID1, 5);
        register.enterItem(testItemID2, 10);
        register.enterItem(testItemID3, 3);

        Sale sale = register.getSale();
        sale.makeBill();
    }
}
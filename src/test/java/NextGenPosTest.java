import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.nextGenPos.*;

import static org.junit.jupiter.api.Assertions.*;

class NextGenPosTest {

    private Store store;
    private ProductCatalog productCatalog;
    private Inventory inventory;
    private Register register;
    private ItemID testItemID;
    private Money testItemPrice;
    private int initialStockQuantity;

    @BeforeEach
    void setUp() {
        store = new Store();
        productCatalog = store.getCatalog();
        inventory = store.getInventory();
        register = store.getRegister();
        testItemID = new ItemID(1); // Assuming ItemID is a valid class
        testItemPrice = new Money(100); // Assuming Money is a valid class
        initialStockQuantity = 10;

        // Setting up the product catalog and inventory
        productCatalog.addProductSpecification(testItemID, new ProductSpecification(testItemPrice, "Test Product"));
        inventory.addStock(testItemID, initialStockQuantity);
    }

    @Test
    void testCompleteSaleProcess() {
        // Start a new sale
        register.makeNewSale();

        // Enter item into the sale
        int quantitySold = 3;
        register.enterItem(testItemID, quantitySold);

        // Complete the sale
        register.setPaymentMethod(new CashPayment()); // Assuming CashPayment is a valid class
        register.makePayment(new Money(300)); // Paying with sufficient money
        register.endSale();

        // Check if inventory is updated correctly
        int expectedRemainingStock = initialStockQuantity - quantitySold;
        assertEquals(expectedRemainingStock, inventory.getStockQuantity(testItemID));

        // Verify if sale is marked as complete
        assertTrue(register.getSale().isComplete());

        // Verify if the total amount is correct
        Money expectedTotal = testItemPrice.times(quantitySold);
        assertEquals(expectedTotal.getAmount(), register.getSale().getTotal().getAmount());
    }

    @Test
    void testSaleWithInsufficientPayment() {
        // Start a new sale
        register.makeNewSale();

        // Enter item into the sale
        register.enterItem(testItemID, 2);

        // Attempt to make payment with insufficient money
        register.setPaymentMethod(new CashPayment()); // Assuming CashPayment is a valid class
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            register.makePayment(new Money(150)); // Insufficient payment
        });

        // Verify if the sale is still incomplete
        assertFalse(register.getSale().isComplete());

        // Check if inventory is not updated (since payment failed)
        assertEquals(initialStockQuantity, inventory.getStockQuantity(testItemID));
    }

    @Test
    void testMultipleItemsSale() {
        // Adding a second item for this test
        ItemID secondItemID = new ItemID(2);
        Money secondItemPrice = new Money(200);
        int secondItemStockQuantity = 5;
        productCatalog.addProductSpecification(secondItemID,
                new ProductSpecification(secondItemPrice, "Second Test Product"));
        inventory.addStock(secondItemID, secondItemStockQuantity);

        // Start a new sale and add multiple items
        register.makeNewSale();
        register.enterItem(testItemID, 1); // First item
        register.enterItem(secondItemID, 2); // Second item

        // Complete the sale
        register.setPaymentMethod(new CashPayment());
        register.makePayment(new Money(500)); // Total 1*100 + 2*200 = 500
        register.endSale();

        // Verify if the sale is complete and inventory is updated correctly
        assertTrue(register.getSale().isComplete());
        assertEquals(initialStockQuantity - 1, inventory.getStockQuantity(testItemID));
        assertEquals(secondItemStockQuantity - 2, inventory.getStockQuantity(secondItemID));

        // Verify if the total amount is correct
        Money expectedTotal = testItemPrice.times(1).add(secondItemPrice.times(2));
        assertEquals(expectedTotal.getAmount(), register.getSale().getTotal().getAmount());
    }
}

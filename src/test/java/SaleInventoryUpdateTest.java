import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.nextGenPos.*;

import static org.junit.jupiter.api.Assertions.*;

class SaleInventoryUpdateTest {

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
    void testInventoryUpdateAfterSale() {
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
    }
}

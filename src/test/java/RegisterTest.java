import org.junit.jupiter.api.Test;
import org.nextGenPos.*;

import static org.junit.jupiter.api.Assertions.*;

class RegisterTest {
    @Test
    void testSaleProcess() {
        ProductCatalog catalog = new ProductCatalog();
        Register register = new Register(catalog);
        register.makeNewSale();
        assertNotNull(register.getSale());
    }

    @Test
    void testEnterItem() {
        ProductCatalog catalog = new ProductCatalog();
        ItemID itemId = new ItemID(1);
        Money price = new Money(100);
        String description = "Test Product";
        catalog.addProductSpecification(itemId, new ProductSpecification(itemId, price, description));

        Register register = new Register(catalog);
        register.makeNewSale();
        register.enterItem(itemId, 2);

        Sale currentSale = register.getSale();
        Money expectedTotal = new Money(200);
        assertEquals(expectedTotal.getAmount(), currentSale.getTotal().getAmount());
    }

    @Test
    void testEndSale() {
        ProductCatalog catalog = new ProductCatalog();
        Register register = new Register(catalog);
        register.makeNewSale();
        register.endSale();

        assertTrue(register.getSale().isComplete());
    }

    @Test
    void testMakeCashPayment() {
        ProductCatalog catalog = new ProductCatalog();
        ItemID itemId = new ItemID(1);
        Money price = new Money(100);
        catalog.addProductSpecification(itemId, new ProductSpecification(itemId, price, "Test Product"));

        Register register = new Register(catalog);
        register.setPaymentMethod(new CashPayment());
        register.makeNewSale();
        register.enterItem(itemId, 2);
        register.makePayment(new Money(200));

        Sale currentSale = register.getSale();
        assertEquals(200, currentSale.getPayment().getAmount().getAmount());
    }

    @Test
    void testMakeCreditCardPayment() {
        ProductCatalog catalog = new ProductCatalog();
        ItemID itemId = new ItemID(1);
        Money price = new Money(100);
        catalog.addProductSpecification(itemId, new ProductSpecification(itemId, price, "Test Product"));

        Register register = new Register(catalog);
        register.setPaymentMethod(new CreditCardPayment());
        register.makeNewSale();
        register.enterItem(itemId, 2);
        register.makePayment(new Money(200));

        Sale currentSale = register.getSale();
        assertEquals(200, currentSale.getPayment().getAmount().getAmount());
    }
}

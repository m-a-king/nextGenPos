import org.junit.jupiter.api.Test;
import org.nextGenPos.*;

import static org.junit.jupiter.api.Assertions.*;

class SaleTest {
    @Test
    void testAddLineItemAndTotal() {
        Sale sale = new Sale();
        ProductCatalog catalog = new ProductCatalog();
        ItemID itemId = new ItemID(1);
        Money price = new Money(100);
        catalog.addProductSpecification(itemId, new ProductSpecification(itemId, price, "Test Product"));
        sale.makeLineItem(price, 2);
        assertEquals(200, sale.getTotal().getAmount());
    }

    @Test
    void testPayment() {
        Sale sale = new Sale();
        Money cashTendered = new Money(500);
        sale.makePayment(cashTendered);
        assertEquals(500, sale.getPayment().getAmount().getAmount());
    }
}

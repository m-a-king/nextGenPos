import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.nextGenPos.*;

import static org.junit.jupiter.api.Assertions.*;

class SaleTest {

    private Sale sale;
    private PaymentMethod paymentMethod;

    @BeforeEach
    void setUp() {
        sale = new Sale();
        paymentMethod = new CashPayment();
    }

    @Test
    void testAddLineItemAndTotal() {
        ProductCatalog catalog = new ProductCatalog();
        ItemID itemId = new ItemID(1);
        Money price = new Money(100);
        catalog.addProductSpecification(itemId, new ProductSpecification(itemId, price, "Test Product"));
        sale.makeLineItem(price, 2);
        assertEquals(200, sale.getTotal().getAmount());
    }

    @Test
    void testPayment() {
        Money cashTendered = new Money(500);
        sale.makePayment(cashTendered, paymentMethod);
        assertEquals(500, sale.getPayment().getAmount().getAmount());
    }

    @Test
    void testGetBalance() {
        Money price = new Money(100);
        int quantity = 2;
        sale.makeLineItem(price, quantity);
        Money cashTendered = new Money(250);
        sale.makePayment(cashTendered, paymentMethod);

        int expectedBalance = cashTendered.getAmount() - price.getAmount() * quantity;

        assertEquals(expectedBalance, sale.getBalance().getAmount());
    }
}

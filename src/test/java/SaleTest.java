import org.junit.jupiter.api.Test;
import org.nextGenPos.Money;
import org.nextGenPos.Sale;

import static org.junit.jupiter.api.Assertions.*;

public class SaleTest {

    @Test
    void testSaleTotal() {
        Sale sale = new Sale();
        sale.makeLineItem(new Money(100), 2);
        sale.makeLineItem(new Money(200), 1);
        Money total = sale.getTotal();
        assertEquals(400, total.getAmount());
    }
}
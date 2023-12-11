import org.junit.jupiter.api.Test;
import org.nextGenPos.Customers;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {
    private Customers customers;

    @BeforeEach
    void setUp() {
        customers = new Customers();
    }

    @Test
    void testAddCustomer() {
        CustomerID customerID = new CustomerID(1);
        customers.addCustomer(customerID);
        assertEquals(customerID, customers.getPointByCustomerId(customerID));
    }

    @Test
    void testGetPointByCustomerId() {
        CustomerID customerID = new CustomerID(123);
        customers.addCustomer(customerID);
        assertEquals(123, customers.getPointByCustomerId(customerID).getPoint());
    }
}

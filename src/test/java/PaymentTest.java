import org.junit.jupiter.api.Test;
import org.nextGenPos.Money;
import org.nextGenPos.Payment;

import static org.junit.jupiter.api.Assertions.*;

class PaymentTest {
    @Test
    void testPaymentCreation() {
        Money cashTendered = new Money(500);
        Payment payment = new Payment(cashTendered);
        assertEquals(500, payment.getAmount().getAmount());
    }
}

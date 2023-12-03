import org.junit.jupiter.api.Test;
import org.nextGenPos.Money;

import static org.junit.jupiter.api.Assertions.*;

public class MoneyTest {

    @Test
    void testAdd() {
        Money money1 = new Money(100);
        Money money2 = new Money(200);
        money1.add(money2);
        assertEquals(300, money1.getAmount());
    }

    @Test
    void testMinus() {
        Money total = new Money(500);
        Money amount = new Money(200);
        Money result = amount.minus(total);
        assertEquals(-300, result.getAmount());
    }

    @Test
    void testTimes() {
        Money money = new Money(100);
        Money result = money.times(3);
        assertEquals(300, result.getAmount());
    }
}

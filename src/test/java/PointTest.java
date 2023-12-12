import org.junit.jupiter.api.Test;
import org.nextGenPos.Point;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {
    @Test
    void testPointAdd() {
        Point point1 = new Point(100);
        Point point2 = new Point(200);
        Point result = point1.add(point2);
        assertEquals(300,result.getPoint());
    }

    @Test
    void testPointMinus() {
        Point point1 = new Point(500);
        Point point2 = new Point(200);
        Point result = point1.minus(point2);
        assertEquals(300,result.getPoint());
    }
}

package delivery;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryStrategyTest {
    DeliveryManager m;
    DeliveryStrategy ds;

    @BeforeEach
    void setUp() {
        m = new PostDeliveryStrategy();
        ds = new DeliveryStrategy(m);
    }

    @Test
    void getDeliveryPrice() {
        assertEquals(10, ds.getDeliveryPrice("str", true));
    }
}
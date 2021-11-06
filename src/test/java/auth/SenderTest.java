package auth;

import internalService.InternalStatus;
import order.OrderStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class SenderTest {

    Sender s1, s2;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        this.s1 = new Sender();
        this.s2 = new Sender();
    }

    @Test
    void update() {
        System.setOut(new PrintStream(outContent));
        InternalStatus s = OrderStatus.ORDER_STATUS_OK;
        s1.update(s);

        System.setOut(System.out);
        assertTrue(outContent.toString().contains("successful"));
    }

    @Test
    void getId() {
        assertEquals(1, s1.getId());
        assertEquals(2, s2.getId());
    }
}
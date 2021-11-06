package auth;

import internalService.InternalStatus;
import order.OrderStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class SenderTest {

    static Sender s1 = new Sender();
    static Sender s2 = new Sender();

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();


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
        System.out.println(s1);
        assertEquals(1, s1.GetId());
        assertEquals(2, s2.GetId());
    }
}
package payments;

import flowers.FlowerBucket;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentStrategyTest {
    public static int DEFAULT_BALANCE = 100;

    // this will be received during user's registration, for instance
    // PaymentManager m = new CreditCardPaymentStrategy(100);
    PaymentManager m;

    // this will be initialised in the user's class
    PaymentStrategy ps;

    // bucket that he decides to buy
    FlowerBucket b;

    @BeforeEach
    void setUp() {
        m = new PayPalPaymentStrategy(DEFAULT_BALANCE);
        ps = new PaymentStrategy(m);
        b = new FlowerBucket();
    }

    @Test
    void buyBucket() {
        ps.BuyBucket(b);
        // as buy bucket returns transaction and does not modify the
        // underlying balance
        assertEquals(DEFAULT_BALANCE, m.getCurrentBalance());
    }

    @Test
    @SneakyThrows
    void processPayment_1() {
        Transaction t = ps.BuyBucket(b);
        ps.ProcessPayment(t);
        assertEquals(DEFAULT_BALANCE - b.getPrice() * m.getFee(), m.getCurrentBalance());
    }

    @Test
    void processPayment() {
        m = new PayPalPaymentStrategy(DEFAULT_BALANCE - DEFAULT_BALANCE);
        ps = new PaymentStrategy(m);
        Transaction t = ps.BuyBucket(b);
        assertThrows(Exception.class, () -> ps.ProcessPayment(t));
    }
}
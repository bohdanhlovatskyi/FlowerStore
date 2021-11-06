package auth;

import delivery.DeliveryManager;
import delivery.DeliveryStatus;
import delivery.DeliveryStrategy;
import internalService.InternalStatus;
import lombok.Getter;
import order.OrderStatus;
import payments.PaymentManager;
import payments.PaymentStatus;
import payments.PaymentStrategy;

@Getter
public class Sender implements User {
    // ISSUE: this is unsafe, might easily overflow
    private static int numOfSenders = 0;
    private int id;

    private PaymentStrategy ps;
    private DeliveryStrategy ds;

    public Sender() {
        numOfSenders += 1;
        this.id = numOfSenders;
    }

    public int GetId() {
        return this.id;
    }

    public void update(InternalStatus status) {
        // System.out.printf("[SENDER]: %s\n", status.toString());
        if (status == OrderStatus.ORDER_STATUS_OK) {
            System.out.println("Your transaction is successful");
        } else {
            System.out.printf("Oooops, something gone wrong: %s\n", status.toString());
        }
    }

    public void addPaymentStrategy(PaymentManager m) {
        this.ps = new PaymentStrategy(m);
    }

    public void addDeliveryStrategy(DeliveryManager d) {
        this.ds = new DeliveryStrategy(d);
    }

    public double getBalance() { return this.ps.getBalance(); };
}

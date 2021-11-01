package auth;

import delivery.DeliveryStatus;
import internalService.InternalStatus;
import lombok.Getter;
import order.OrderStatus;

@Getter
public class Receiver implements User {
    // ISSUE: this is unsafe, might easily overflow
    private static int numOfReceivers = 0;
    private int id = 0;
    private String address;

    public Receiver() {
        numOfReceivers += 1;
        this.id = numOfReceivers;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void update(InternalStatus status) {
        // System.out.printf("[RECEIVER]: %s\n", status.toString());
        if (status == OrderStatus.ORDER_STATUS_OK) {
            System.out.println("Your flowers are waiting for you");
        } else {
            System.out.println("Wait for your flowers...");
        }
    }
}

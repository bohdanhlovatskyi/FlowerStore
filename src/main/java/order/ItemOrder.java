package order;

import auth.Sender;
import auth.User;
import delivery.DeliveryStatus;
import delivery.DeliveryStrategy;
import flowers.FlowerBucket;
import flowers.Item;
import internalService.InternalStatus;
import lombok.Setter;
import payments.PaymentStatus;
import payments.PaymentStrategy;
import payments.Transaction;

import java.util.ArrayList;
import java.util.List;

@Setter
public class ItemOrder {
    private User user;
    public List<FlowerBucket> items = new ArrayList<>();
    public String deliveryAddress;
    public boolean fastDelivery;
    private PaymentStrategy p;
    private DeliveryStrategy d;

    public ItemOrder(Sender user) {
        this.user = user;
        this.p = user.getPs();
        this.d = user.getDs();
    }

    public static ItemOrder fromBuckets(Sender user, FlowerBucket... items) {
        ItemOrder o = new ItemOrder(user);
        for (FlowerBucket b : items) {
            o.addItem(b);
        }

        return o;
    }

    public void addItem(FlowerBucket item) { items.add(item); }
    public boolean removeItem(FlowerBucket item) { return items.remove(item); }

    public InternalStatus processOrder() {
        List<Transaction> tr = new ArrayList<>();

        if (this.deliveryAddress == null) {
            return DeliveryStatus.DELIVERY_STATUS_FAULT;
        }

        for (FlowerBucket b : this.items) {
            tr.add(this.p.BuyBucket(b));
        }

        tr.add(p.BuyDelivery(
                this.d.getDeliveryPrice(
                        this.deliveryAddress,
                        this.fastDelivery
                )));

        PaymentStatus s = this.p.ProcessPayment(tr.toArray(new Transaction[0]));
        if (s != PaymentStatus.PAYMENT_STATUS_OK) {
            return s;
        }

        return OrderStatus.ORDER_STATUS_OK;
    }

    public double calculateTotalPrice(String address, boolean fast) {
        double amount = 0;
        for (FlowerBucket b : this.items) {
            amount += this.p.BuyBucket(b).amount;
        }

        amount += this.p.BuyDelivery(this.d.getDeliveryPrice(address, fast)).amount;

        return amount;
    }

}
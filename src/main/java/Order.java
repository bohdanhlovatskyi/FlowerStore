import delivery.DeliveryStrategy;
import flowers.FlowerBucket;
import payments.PaymentStrategy;
import payments.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Order {
    public List<FlowerBucket> items = new ArrayList<>();
    public String deliveryAddress;
    public boolean fastDelivery;
    private PaymentStrategy p;
    private DeliveryStrategy d;

    public void setPayment(PaymentStrategy p) { this.p = p; }
    public void setDelivery(DeliveryStrategy d) { this.d = d; }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public void setFastDelivery(boolean fastDelivery) {
        this.fastDelivery = fastDelivery;
    }

    public void addItem(FlowerBucket item) { items.add(item); }
    public boolean removeItem(FlowerBucket item) { return items.remove(item); }

    public void processOrder() throws Exception {
        List<Transaction> tr = new ArrayList<>();

        if (this.deliveryAddress == null) {
            throw new Exception("You have to specify delivery address");
        }

        for (FlowerBucket b : this.items) {
            tr.add(this.p.BuyBucket(b));
        }

        tr.add(p.BuyDelivery(
                this.d.getDeliveryPrice(
                        this.deliveryAddress,
                        this.fastDelivery
                )));

        this.p.ProcessPayment(tr.toArray(new Transaction[0]));
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

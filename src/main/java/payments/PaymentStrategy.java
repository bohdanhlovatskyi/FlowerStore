package payments;

import flowers.FlowerBucket;
import lombok.Getter;

@Getter
public class PaymentStrategy {
    private PaymentManager p;

    public PaymentStrategy(PaymentManager p) {
        this.p = p;
    }

    public Transaction BuyBucket(FlowerBucket b) {
        return this.p.BuyBucket(b);
    }

    public Transaction BuyDelivery(double deliveryPrice) {
        return this.p.ProcessDeliveryFee(deliveryPrice);
    }

    public PaymentStatus ProcessPayment(Transaction... tr) {
        return this.p.ProcessTransaction(tr);
    }

    public double getBalance() { return this.p.getBalance(); };
}
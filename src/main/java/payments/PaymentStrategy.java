package payments;

import flowers.FlowerBucket;

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

    public void ProcessPayment(Transaction... tr) throws Exception {
        this.p.ProcessTransaction(tr);
    }
}
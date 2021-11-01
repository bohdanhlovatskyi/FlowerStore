package payments;

import flowers.FlowerBucket;
import lombok.Getter;

public abstract class DefaultPaymentStratetegy implements PaymentManager {
    protected double amount;
    protected double FEE;

    public Transaction BuyBucket(FlowerBucket b) {
        // gets price of chosen bucket
        double sum = b.getPrice();

        // add
        sum *= this.FEE;

        if ((this.amount - sum) < 0) {
            return new Transaction("Buy bucket", 0, false);
        }

        return new Transaction("Buy bucket", sum, true);
    }

    public Transaction ProcessDeliveryFee(double deliveryPrice) {
        if ((this.amount - deliveryPrice) < 0) {
            return new Transaction("Delivery", 0, false);
        }

        return new Transaction("Buy bucket", deliveryPrice, true);
    }

    public PaymentStatus ProcessTransaction(Transaction... transactions) {
        double amount = 0;
        for (Transaction t : transactions) {
            if (!t.isSuccessful) {
                return PaymentStatus.PAYMENT_STATUS_FAULT;
            }
            amount += t.amount;
        }

        this.amount -= amount;

        return PaymentStatus.PAYMENT_STATUS_OK;
    }

    public double getCurrentBalance() {
        return this.amount;
    }

    @Override
    public double getFee() { return this.FEE; }

    @Override
    public double getBalance() {
        return this.amount;
    }
}

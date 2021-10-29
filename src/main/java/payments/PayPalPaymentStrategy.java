package payments;

import flowers.FlowerBucket;

public class PayPalPaymentStrategy extends DefaultPaymentStratetegy implements PaymentManager {
    public PayPalPaymentStrategy(double amount) {
        this.amount = amount;
        this.FEE = 0.1;
    }

    @Override
    public Transaction BuyBucket(FlowerBucket b) {
        Transaction res = super.BuyBucket(b);
        if (res.isSuccessful != true) {
            System.out.println("PayPal BuyBucket failure");
        } else {
            System.out.println("PayPal BuyBucket success");
        }

        return res;
    }

    @Override
    public Transaction ProcessDeliveryFee(double deliveryPrice) {
        Transaction res = super.ProcessDeliveryFee(deliveryPrice);
        if (res.isSuccessful != true) {
            System.out.println("PayPal Delivery failure");
        } else {
            System.out.println("PayPal Delivery success");
        }

        return res;
    }
}

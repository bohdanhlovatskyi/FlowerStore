package payments;

import flowers.FlowerBucket;

public class CreditCardPaymentStrategy extends DefaultPaymentStratetegy implements PaymentManager {

    public CreditCardPaymentStrategy(double amount) {
        this.amount = amount;
        this.FEE = 0.1;
    }

    @Override
    public Transaction BuyBucket(FlowerBucket b) {
        Transaction res = super.BuyBucket(b);
        if (res.isSuccessful != true) {
            System.out.println("Credit card BuyBucket failure");
        } else {
            System.out.println("Credit card BuyBucket success");
        }

        return res;
    }

    @Override
    public Transaction ProcessDeliveryFee(double deliveryPrice) {
        Transaction res = super.ProcessDeliveryFee(deliveryPrice);
        if (res.isSuccessful != true) {
            System.out.println("Credit Card Delivery failure");
        } else {
            System.out.println("Credit Card Delivery success");
        }

        return res;
    }
}

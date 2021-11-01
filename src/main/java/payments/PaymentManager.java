package payments;

import flowers.FlowerBucket;

public interface PaymentManager {

    PaymentStatus ProcessTransaction(Transaction... transactions);

    double getCurrentBalance();

    Transaction ProcessDeliveryFee(double deliveryPrice);

    Transaction BuyBucket(FlowerBucket b);

    double getFee();

    double getBalance();
}

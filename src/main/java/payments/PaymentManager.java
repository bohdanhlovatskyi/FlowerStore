package payments;

import flowers.FlowerBucket;

public interface PaymentManager {

    void ProcessTransaction(Transaction... transactions) throws Exception;

    double getCurrentBalance();

    Transaction ProcessDeliveryFee(double deliveryPrice);

    Transaction BuyBucket(FlowerBucket b);

    double getFee();
}

import delivery.DeliveryManager;
import delivery.DeliveryStrategy;
import delivery.PostDeliveryStrategy;
import flowers.FlowerBucket;
import payments.*;

public class Test {

    public static void main(String[] args) {
        // this will be received during user's registration, for instance
        // PaymentManager m = new CreditCardPaymentStrategy(100);
        PaymentManager m = new PayPalPaymentStrategy(100);
        DeliveryManager d = new PostDeliveryStrategy();

        // this will be initialised in the user's class
        PaymentStrategy ps = new PaymentStrategy(m);
        DeliveryStrategy ds = new DeliveryStrategy(d);

        // bucket that he decides to buy
        FlowerBucket b1 = new FlowerBucket();
        FlowerBucket b2 = new FlowerBucket();

        Order o = new Order();
        o.setPayment(ps);
        o.setDelivery(ds);
        o.addItem(b1);
        o.addItem(b2);
        o.setDeliveryAddress("UCU");
        o.setFastDelivery(true);

        try {
            o.processOrder();
            System.out.println("Success");
        } catch (Exception ex) {
            System.out.println("Sadly, but transaction was not ok");
        }

    }
}

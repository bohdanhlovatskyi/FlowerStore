import auth.Receiver;
import auth.Sender;
import decorators.BasketDecorator;
import decorators.PaperDecorator;
import delivery.DeliveryManager;
import delivery.PostDeliveryStrategy;
import flowers.*;
import internalService.InternalStatus;
import order.ItemOrder;
import order.Order;
import payments.*;

public class Client {

    public static void main(String[] args) {
        // this will be received during user's registration, for instance
        // PaymentManager m = new CreditCardPaymentStrategy(100);
        PaymentManager m = new PayPalPaymentStrategy(100);
        DeliveryManager d = new PostDeliveryStrategy();

        // after registration new user class will be created
        // and initialised
        Sender u = new Sender();
        u.addPaymentStrategy(m);
        u.addDeliveryStrategy(d);

        // bucket that he decides to buy
        Flower fl = new PaperDecorator(
                new BasketDecorator(
                        new Flower(FlowerType.CHAMOMILE)
                )
        );

        FlowerBucket b1 = new FlowerBucket();
        b1.addFlowerPack(new FlowerPack(fl, 3));
        FlowerBucket b2  = new FlowerBucket();

        Receiver r = new Receiver();
        r.setAddress("UCU");

        // Quick order (static factory to create an object)
        ItemOrder o = ItemOrder.fromBuckets(u, b1, b2);
        o.setDeliveryAddress(r.getAddress());
        o.setFastDelivery(true);

        System.out.printf("Your balance before transaction: %f\n", u.getBalance());
        InternalStatus s = o.processOrder();
        System.out.println(s);

        Order order = new Order(o);
        order.addUser(r);
        order.addUser(u);

        order.notifyUsers();

        System.out.printf("Your balance after transaction: %f\n", u.getBalance());
    }
}

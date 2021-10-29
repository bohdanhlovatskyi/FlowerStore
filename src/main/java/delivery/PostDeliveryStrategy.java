package delivery;

public class PostDeliveryStrategy implements DeliveryManager {
    public final double DELIVERY_PRICE = 10.0;

    public double deliver(String address, boolean fast_delivery) {
        return DELIVERY_PRICE;
    }
}

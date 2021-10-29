package delivery;

public class PostDeliveryStrategy implements DeliveryManager {

    public double deliver(String address, boolean fast_delivery) {
        return 10.0;
    }
}

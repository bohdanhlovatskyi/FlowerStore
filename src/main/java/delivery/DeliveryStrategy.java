package delivery;

public class DeliveryStrategy {
    private DeliveryManager m;

    public DeliveryStrategy(DeliveryManager m) {
        this.m = m;
    }

    public double getDeliveryPrice(String address, boolean fast) {
        return m.deliver(address, fast);
    }
}

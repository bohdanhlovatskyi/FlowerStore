package delivery;

public interface DeliveryManager {

    /**
     * Calculates price of delivery
     *
     * @param address
     * @param fast_delivery
     * @return price of delivery
     */
    double deliver(String address, boolean fast_delivery);
}

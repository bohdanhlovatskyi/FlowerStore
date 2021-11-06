package decorators;

import flowers.Flower;

public class BasketDecorator extends Flower implements ItemDecorator {

    private Flower item;

    public BasketDecorator(Flower item) {
        super(item.getFlType());
        this.item = item;
    }

    public double getPrice() {
        return this.item.getPrice() + 20;
    }

    public String getDescription() {
        return String.format("%s; %s", this.item.getDescription(), "Decorated with busket");
    }
}

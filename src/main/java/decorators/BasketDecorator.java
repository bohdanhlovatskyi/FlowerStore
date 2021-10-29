package decorators;

import flowers.Item;

public class BasketDecorator extends ItemDecorator {

    public BasketDecorator(Item item) {
        super(item);
    }

    public double getPrice() {
        return this.item.getPrice() + 20;
    }

    public String getDescription() {
        return String.format("%s; %s", this.item.getDescription(), "Decorated with busket");
    }
}

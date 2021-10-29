package decorators;

import flowers.Item;

public class PaperDecorator extends ItemDecorator {

    public PaperDecorator(Item item) {
        super(item);
    }

    public double getPrice() {
        return this.item.getPrice() + 10;
    }

    public String getDescription() {
        return String.format("%s; %s", this.item.getDescription(), "Decorated with paper");
    }
}
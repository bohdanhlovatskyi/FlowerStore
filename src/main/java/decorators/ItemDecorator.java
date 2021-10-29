package decorators;

import flowers.Item;

public abstract class ItemDecorator extends Item {
    protected Item item;

    public ItemDecorator(Item item) {
        this.item = item;
    }

    public abstract double getPrice();

    public abstract String getDescription();
}

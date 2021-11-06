package decorators;

import flowers.Flower;

public class PaperDecorator extends Flower implements ItemDecorator {

    private Flower item;

    public PaperDecorator(Flower fl) {
        super(fl.getFlType());
        this.item = fl;
    }

    public double getPrice() {
        return this.item.getPrice() + 10;
    }

    public String getDescription() {
        return String.format("%s; %s", this.item.getDescription(), "Decorated with paper");
    }
}
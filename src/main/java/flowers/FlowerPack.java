package flowers;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * FlowerPack class with attributes flower and amount. Implement method price in it
 */
@Setter @ToString
public class FlowerPack {
    private Flower fl;
    protected int amount;

    public FlowerPack(Flower fl, int amount) {
        setFl(fl);
        setAmount(amount);
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public FlowerType getFlowerType() {
        return this.fl.getFlType();
    }

    public Flower getFlower() throws Exception {
        if (getAmount() < 1) {
            throw new IndexOutOfBoundsException("Flower pack is empty");
        }

        this.amount -= 1;

        return fl;
    }

    public boolean hasFlower() {
        return amount >= 1;
    }

    public double getPrice() {
        return fl.getPrice() * this.amount;
    }
}

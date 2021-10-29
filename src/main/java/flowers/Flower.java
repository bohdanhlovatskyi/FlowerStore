package flowers;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;

/**
 * Flower or system of classes that implement the essence of
 * Rose, Chamomile, Tulip in a flower store.
 *
 * Has attributes sepalLength, color, and price.
 */
@Setter @Getter @ToString
public class Flower extends Item {
    private static double DEFAULT_PRICE = 10;
    private double price;
    private double sepalLength;
    private int[] color;
    private FlowerType flType;

    public Flower(FlowerType flType) {
        this.flType = flType;
        this.price = DEFAULT_PRICE;
    }

    // custom setter that makes sure that the color will be saved properly
    public void setColor(int[] color) {
        this.color = Arrays.copyOf(color, color.length);
    }

    public String getDescription() {
        return String.format("Flower{price:  %f, sepal length: %f, flower type: %s}",
                this.price, this.sepalLength, this.flType);
    }

    public double getPrice() {
        return this.price;
    }
}
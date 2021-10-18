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
public class Flower {
    private double price;
    private double sepalLength;
    private int[] color;
    private FlowerType flType;

    public Flower(FlowerType flType) {
        this.flType = flType;
    }

    // custom setter that makes sure that the color will be saved properly
    public void setColor(int[] color) {
        this.color = Arrays.copyOf(color, color.length);
    }
}
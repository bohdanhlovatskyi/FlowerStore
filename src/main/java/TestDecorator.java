import decorators.BasketDecorator;
import decorators.PaperDecorator;
import flowers.Flower;
import flowers.FlowerType;
import flowers.Item;

public class TestDecorator {

    public static void main(String[] args) {
        Item it = new PaperDecorator(
                    new BasketDecorator(
                        new Flower(FlowerType.CHAMOMILE)
                    )
        );

        System.out.println(it.getDescription());
        System.out.printf("The price is: %f\n", it.getPrice());
    }
}

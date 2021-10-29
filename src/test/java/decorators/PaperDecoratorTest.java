package decorators;

import flowers.Flower;
import flowers.FlowerType;
import flowers.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaperDecoratorTest {

    Item i = new Flower(FlowerType.CHAMOMILE);
    PaperDecorator p = new PaperDecorator(i);

    @Test
    void getPrice() {
        assertNotEquals(p.getPrice(), i.getPrice());
    }

    @Test
    void getDescription() {
        boolean check;
        String d = p.getDescription();
        check = d.contains("paper");
        assertTrue(check);
    }
}
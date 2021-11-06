package order;

import auth.Sender;
import flowers.FlowerBucket;
import flowers.FlowerPack;
import flowers.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemOrderTest {

    ItemOrder o;

    @BeforeEach
    void setUp() {
        FlowerBucket b = new FlowerBucket();
        this.o = ItemOrder.fromBuckets(new Sender(), b, b);
    }

    @Test
    void fromBuckets() {
        assertEquals(2, this.o.items.size());
    }
}
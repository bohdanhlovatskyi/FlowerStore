package flowers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlowerBucketTest {

    FlowerBucket b;
    // 3 types 5 flowers 5 dollars each
    int DEFAULT_BUCKET_INITIALIZER_PRICE = 75;
    int DEFAULT_BUCKET_PACK_SIZE = 5;

    @BeforeEach
    void setUp() {
        b = new FlowerBucket();
    }

    @Test
    void takeFlower() {
        Flower f = b.takeFlower(FlowerType.CHAMOMILE);
        // one of the flowers was taken, therefore price should become less
        assertEquals(DEFAULT_BUCKET_INITIALIZER_PRICE - f.getPrice(), b.getPrice());

        Flower ff;
        // checks also that flower won't be taken  if there is not any left
        for (int i = 0; i < 6; i++) {
            ff = b.takeFlower(FlowerType.CHAMOMILE);
        }
        assertEquals(DEFAULT_BUCKET_INITIALIZER_PRICE -
            (DEFAULT_BUCKET_PACK_SIZE) * f.getPrice(), b.getPrice());
    }

    @Test
    void getPrice() {
        // this is hardcoded
        assertEquals(DEFAULT_BUCKET_INITIALIZER_PRICE, b.getPrice());
    }
}
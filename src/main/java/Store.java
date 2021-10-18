import flowers.Flower;
import flowers.FlowerBucket;
import flowers.FlowerType;

/**
 * class Store and method search in it
 */
public class Store {
    private FlowerBucket flBucket;

    public Store() {
        // default initialises the flower bucket using its
        // initialiser
        this.flBucket = new FlowerBucket();
    }

    public Store(FlowerBucket flBucket) {
        this.flBucket = flBucket;
    }

    /**
     * Note that this function consumes a flower,
     * so if one does not want to use it, he has to return
     * it to the bucket
     * @param fltype
     * @return
     */
    public Flower search(FlowerType fltype) {
        return flBucket.takeFlower(fltype);
    }
}

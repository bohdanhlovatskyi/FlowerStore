package flowers;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * FlowerBucket class that will aggregate several FlowerPack-s.
 * Method price in it.
 */
@ToString
public class FlowerBucket {
    List<FlowerPack> flPacks = new ArrayList<>();

    public FlowerBucket() {
        for (FlowerType flType : FlowerType.values()) {
            Flower f = new Flower(flType);
            f.setPrice(5.0);
            this.addFlowerPack(new FlowerPack(f, 5));
        }
    }


    public void addFlowerPack(FlowerPack p) {
        flPacks.add(p);
    }

    /**
     * @param flType - type of flower that one wants to buy
     * @return - null if flower was not found, flower otherwise
     */
    public Flower takeFlower(FlowerType flType) {

        // iterates over flower packs in order to find a flower
        for (int i = 0; i < flPacks.size(); i++) {
            if (flType.equals(flPacks.get(i).getFlowerType())) {
                FlowerPack p = flPacks.get(i);

                // tries to get a flower from a flower pack
                Flower flToGet;
                try {
                    flToGet = p.getFlower();
                } catch (Exception ex) {
                    continue;
                }

                // flower pack is empty, removes it
                if (p.getAmount() == 0) {
                    flPacks.remove(i);
                }

                return flToGet;
            }
        }

        return null;
    }

    // add flower pack
    public double getPrice() {
        double price = 0;
        for (int i = 0; i < flPacks.size(); i++) {
            price += flPacks.get(i).getPrice();
        }

        return price;
    }
}

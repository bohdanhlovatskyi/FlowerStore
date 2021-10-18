package flowers;

import static org.junit.jupiter.api.Assertions.*;

class FlowerTest {

    Flower fl;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        fl = new Flower(FlowerType.ROSE);
        fl.setColor(new int[]{13, 3, 3});
        fl.setSepalLength(5);
        fl.setPrice(10.0);
    }

    @org.junit.jupiter.api.Test
    void getPrice() {
        assertEquals(fl.getPrice(), 10.0);
    }

    @org.junit.jupiter.api.Test
    void setPrice() {
        fl.setPrice(20.0);
        assertEquals(fl.getPrice(), 20.0);
    }

    @org.junit.jupiter.api.Test
    void setColor() {
        int[] color = new int[]{2, 3, 4};
        fl.setColor(color);
        color[1] = 99;
        assertNotEquals(fl.getColor(), color);
    }

}
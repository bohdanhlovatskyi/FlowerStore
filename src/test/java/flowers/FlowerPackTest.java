package flowers;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlowerPackTest {

    FlowerPack flPack;

    @BeforeEach
    void setUp() {
        Flower fl = new Flower(FlowerType.ROSE);
        fl.setPrice(10);
        flPack = new FlowerPack(fl, 5);
    }

    @Test
    void hasFlower() {
        assertTrue(flPack.hasFlower());
        flPack.setAmount(0);
        assertFalse(flPack.hasFlower());
    }

    @Test
    void setAmount() {
        assertEquals(flPack.getAmount(), 5);
        flPack.setAmount(3);
        assertEquals(flPack.getAmount(), 3);
    }

    @Test
    void getPrice() {
        assertEquals(flPack.getPrice(), 50);
    }

    @SneakyThrows
    @Test
    void getFlower() {
        flPack.setAmount(1);
        Flower fl = flPack.getFlower();
        assertEquals(fl.getFlType(), FlowerType.ROSE);

        Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> flPack.getFlower());
        assertEquals("Flower pack is empty", exception.getMessage());
    }
}
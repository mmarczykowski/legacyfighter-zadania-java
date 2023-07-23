package legacyfigher.dietary.newproducts.values;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductCounterTest {
    private ProductCounter productCounter;

    @BeforeEach
    private void setup() {
        productCounter = new ProductCounter(2);
    }

    @Test
    public void shouldDecrementCounter() {
        productCounter.decrement();
        assertEquals(1, productCounter.getValue());
    }

    @Test
    public void shouldIncrementCounter() {
        productCounter.increment();
        assertEquals(3, productCounter.getValue());
    }

    @Test
    public void shoudNotAllowCreatingNullCounter() {
        assertThrows(IllegalStateException.class, () -> new ProductCounter(null));
    }

    @Test
    public void shoudNotAllowCreatingNegativeCounter() {
        assertThrows(IllegalStateException.class, () -> new ProductCounter(-1));
    }

    @Test
    public void shouldNotAllowDecrementingCounterBelowZero() {
        productCounter = new ProductCounter(0);
        assertThrows(IllegalStateException.class, () -> productCounter.decrement());
    }

}

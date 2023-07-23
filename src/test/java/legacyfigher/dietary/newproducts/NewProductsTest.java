package legacyfigher.dietary.newproducts;

import legacyfigher.dietary.newproducts.OldProduct;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

public class NewProductsTest {
    private OldProduct oldProduct;

    @BeforeEach
    private void setup() {
        oldProduct = new OldProduct(
                new BigDecimal(10),
                "This is a product.",
                "This product also has a long description.",
                2
        );
    }

    @Test
    public void shouldDecrementCounter() {
        oldProduct.decrementCounter();
        assertEquals(1, oldProduct.getCounter());
    }

    @Test
    public void shouldIncrementCounter() {
        oldProduct.incrementCounter();
        assertEquals(3, oldProduct.getCounter());
    }

    @Test
    public void shouldThrowExceptionWhenDecrementingCounterBelowZero() {
        oldProduct.setCounter(0);
        assertThrows(IllegalStateException.class, () -> oldProduct.decrementCounter());
    }

    @Test
    public void shouldThrowExceptionWhenTryingToIncrementNullException() {
        oldProduct.setCounter(null);
        assertThrows(IllegalStateException.class, () -> oldProduct.incrementCounter());
    }

    @Test
    public void shouldThrowExceptionWhenTryingToIncrementCounterWhenPriceIsNull() {
        oldProduct.setPrice(null);
        assertThrows(IllegalStateException.class, () -> oldProduct.incrementCounter());
    }

    @Test
    public void shouldThrowExceptionWhenTryingToIncrementCounterWhenPriceIsBelowZero() {
        oldProduct.setPrice(new BigDecimal(-1));
        assertThrows(IllegalStateException.class, () -> oldProduct.incrementCounter());
    }
}

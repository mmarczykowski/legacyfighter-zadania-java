package legacyfigher.dietary.newproducts.values;

import lombok.Data;

@Data
public class ProductCounter {
    private Integer value;

    public ProductCounter(Integer value) {
        if (value == null || value < 0) {
            throw new IllegalStateException("Counter cannot be null or negative.");
        }
        this.value = value;
    }

    public void decrement() {
        if (value == 0) {
            throw new IllegalStateException("Counter cannot be negative.");
        }
        value--;
    }

    public void increment() {
        value++;
    }
}

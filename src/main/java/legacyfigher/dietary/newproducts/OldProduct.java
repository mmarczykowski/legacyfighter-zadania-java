package legacyfigher.dietary.newproducts;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class OldProduct {

    UUID serialNumber = UUID.randomUUID();

    BigDecimal price;
    private String desc;

    String longDesc;

    Integer counter;


    public void decrementCounter() {
        if (price != null && price.signum() > 0) {

            if (counter == null) {
                throw new IllegalStateException("null counter");
            }
            counter = counter - 1;
            if (counter < 0) {
                throw new IllegalStateException("Negative counter");
            }
        } else {
            throw new IllegalStateException("Invalid price");

        }

    }

    public OldProduct(BigDecimal price, String desc, String longDesc, Integer counter) {
        this.price = price;
        this.desc = desc;
        this.longDesc = longDesc;
        this.counter = counter;
    }

    public void incrementCounter() {
        if (price != null && price.signum() > 0) {
            if (counter == null) {
                throw new IllegalStateException("null counter");
            }
            if (counter + 1 < 0) {
                throw new IllegalStateException("Negative counter");
            }
            counter = counter + 1;
        } else {
            throw new IllegalStateException("Invalid price");

        }
    }

    void changePriceTo(BigDecimal newPrice) {
        if (counter == null) {
            throw new IllegalStateException("null counter");
        }
        if (counter > 0) {
            if (newPrice == null) {
                throw new IllegalStateException("new price null");
            }
            this.price = newPrice;
        }
    }

    void replaceCharFromDesc(String charToReplace, String replaceWith) {
        if (longDesc == null || longDesc.isEmpty() || desc == null || desc.isEmpty()) {
            throw new IllegalStateException("null or empty desc");
        }
        longDesc = longDesc.replace(charToReplace, replaceWith);
        desc = desc.replace(charToReplace, replaceWith);
    }

    String formatDesc() {
        if (longDesc == null || longDesc.isEmpty() || desc == null || desc.isEmpty()) {
            return "";
        }
        return desc + " *** " + longDesc;
    }


}

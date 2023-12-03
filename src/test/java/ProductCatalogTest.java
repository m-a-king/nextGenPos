import org.junit.jupiter.api.Test;
import org.nextGenPos.ItemID;
import org.nextGenPos.Money;
import org.nextGenPos.ProductCatalog;
import org.nextGenPos.ProductSpecification;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ProductCatalogTest {

    @Test
    void testGetPriceByItemId() {
       Map<ItemID, Money> productSpecifications = new HashMap<>();

        // sample data
        ItemID id1 = new ItemID(1);
        ItemID id2 = new ItemID(2);
        ItemID id3 = new ItemID(2);

        Money price1 = new Money(1000);
        Money price2 = new Money(2000);
        Money price3 = new Money(3000);

        ProductSpecification productSpecification1 = new ProductSpecification(id1, price1, "product 1");
        ProductSpecification productSpecification2 = new ProductSpecification(id2, price2, "product 2");
        ProductSpecification productSpecification3 = new ProductSpecification(id3, price3, "product 3");

        productSpecifications.put(productSpecification1.getItemID(), productSpecification1.getPrice());
        productSpecifications.put(productSpecification2.getItemID(), productSpecification2.getPrice());
        productSpecifications.put(productSpecification3.getItemID(), productSpecification3.getPrice());

        ProductCatalog catalog = new ProductCatalog(productSpecifications);
        Money price = catalog.getPriceByItemId(id1);
        assertNotNull(price);
        assertEquals(1000, price.getAmount());
    }
}

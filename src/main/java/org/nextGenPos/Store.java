package org.nextGenPos;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Store {
    private final ProductCatalog catalog = new ProductCatalog();
    private final Inventory inventory = new Inventory();
    private final Register register = new Register(catalog, inventory);
    private final Customers customers = new Customers();

    public void makeCustomer(CustomerID customerID){
        customers.addCustomer(customerID);
    }
}

package org.nextGenPos;

import lombok.Getter;

@Getter
public class Store {
    private final ProductCatalog catalog;
    private final Register register;

    public Store() {
        this.catalog = new ProductCatalog();
        this.register = new Register(catalog);
    }
}

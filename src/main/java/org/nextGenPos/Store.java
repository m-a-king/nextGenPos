package org.nextGenPos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Store {

    private final ProductCatalog catalog = new ProductCatalog();
    private final Register register = new Register(catalog);
}
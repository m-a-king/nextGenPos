package org.nextGenPos;

import lombok.RequiredArgsConstructor;

// Class Register
@RequiredArgsConstructor
public class Register {

    private final ProductCatalog productCatalog;
    private Sale sale;

    public void makeNewSale() {
        sale = new Sale();
    }

    public void enterItem(ItemID id, int quantity) {
        Money price = productCatalog.getPriceByItemId(id);
        sale.makeLineItem(price, quantity);
    }

    public void endSale() {
        sale.becomeComplete();
    }

    public void makePayment(Money cashTendered) {
        sale.makePayment(cashTendered);
    }
}

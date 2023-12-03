package org.nextGenPos;

// Class Register
public class Register {

    private ProductCatalog catalog;
    private Sale sale;

    public Register(ProductCatalog catalog) {
        this.catalog = catalog;
    }

    public void makeNewSale() {
        sale = new Sale();
    }

    public void enterItem(ItemID id, int quantity) {
        Money price = catalog.getPriceByItemId(id);
        sale.makeLineItem(price, quantity);
    }

    public void endSale() {
        sale.becomeComplete();
    }

    public void makePayment(Money cashTendered) {
        sale.makePayment(cashTendered);
    }
}

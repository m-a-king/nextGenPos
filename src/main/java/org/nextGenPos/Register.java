package org.nextGenPos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

// Class Register
@RequiredArgsConstructor
@Getter
public class Register {

    private final ProductCatalog productCatalog;
    private final Inventory inventory;
    private Sale sale;
    private PaymentMethod paymentMethod;

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void makeNewSale() {
        sale = new Sale();
    }

    public void enterItem(ItemID id, int quantity) {
        Money price = productCatalog.getPriceByItemId(id);
        sale.makeLineItem(id, price, quantity);
    }

    public void makePayment(Money cashTendered) {
        if (paymentMethod == null) {
            throw new IllegalStateException("Payment method not set");
        }
        sale.makePayment(cashTendered, paymentMethod);
    }

    public void endSale() {
        sale.becomeComplete();
        updateInventory();
    }

    private void updateInventory() {
        for (SalesLineItem item : sale.getLineItems()) {
            inventory.removeStock(item.getItemID(), item.getQuantity());
        }
    }


}

package org.nextGenPos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Sale {

    private final List<SalesLineItem> lineItems = new ArrayList<>();
    private final Date date = new Date();
    private boolean isComplete = false;
    private Payment payment;

    public Money getBalance() {
        return payment.getAmount().minus(getTotal());
    }

    public void becomeComplete() {
        isComplete = true;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void makeLineItem(Money price, int quantity) {
        lineItems.add(new SalesLineItem(quantity, price));
    }

    public Money getTotal() {
        Money total = new Money(0);
        for (SalesLineItem sli : lineItems) {
            total.add(sli.getSubtotal());
        }
        return total;
    }

    public void makePayment(Money cashTendered) {
        payment = new Payment(cashTendered);
    }
}
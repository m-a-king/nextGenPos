package org.nextGenPos;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
public class Sale {
    private final List<SalesLineItem> lineItems = new ArrayList<>();
    private final Date date = new Date();
    private boolean isComplete = false;
    private Payment payment;
    private Customers customers;

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public Money getBalance() {
        return payment.getAmount().minus(getTotal());
    }

    public void becomeComplete() {
        isComplete = true;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void makeLineItem(ItemID itemID, Money price, int quantity) {
        lineItems.add(new SalesLineItem(itemID, quantity, price));
    }

    public Money getTotal() {
        Money total = new Money(0);
        for (SalesLineItem sli : lineItems) {
            total = total.add(sli.getSubtotal());
        }
        return total;
    }

    public void makePayment(Money cashTendered, PaymentMethod paymentMethod) {
        Money total = getTotal();
        if (cashTendered.getAmount() < total.getAmount()) {
            throw new IllegalArgumentException("Insufficient amount tendered");
        }
        payment = new Payment(cashTendered, paymentMethod);
    }

    public void savePoint(CustomerID customerID, Point point) {
        customers.addPointByCustomerId(customerID, point);
    }

    public void usePoint(CustomerID customerID, Point point) {
        Point currentPoint = customers.getPointByCustomerId(customerID);
        if (currentPoint.getPoint() < point.getPoint()) {
            throw new IllegalArgumentException("Insufficient point for CustomerID " + customerID);
        }
        customers.minusPointByCustomerId(customerID, point);
    }

    public void makeBill() {
        String temp = "------------";
        System.out.printf("+%s+%s+%s+%s+\n", temp, temp, temp, temp, temp);
        System.out.printf("| %-10s | %-10s | %-10s | %-10s |\n", "ItemID", "Unit Cost", "Quantity", "Amount");
        System.out.printf("+%s+%s+%s+%s+\n", temp, temp, temp, temp, temp);
        for (SalesLineItem sli : lineItems) {
            System.out.printf("| %-10d | %-10d | %-10d | %-10d |\n", sli.getItemID().getItemId(),
                    sli.getPrice().getAmount(), sli.getQuantity(),
                    sli.getPrice().getAmount() * sli.getQuantity());
        }
        System.out.printf("+%s+%s+%s+%s+\n", temp, temp, temp, temp, temp);
        System.out.printf("| %-36s | %-10d |\n", "Total Amount", getTotal().getAmount());
        System.out.printf("+%s+%s+%s+%s+\n", temp, temp, temp, temp, temp);

    }
}

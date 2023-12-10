package org.nextGenPos;

import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
public class Customers {
    private final Map<CustomerID, Point> customers = new HashMap<>();

    public void addCustomer(CustomerID customerID) {
        Point point = new Point(0);
        customers.put(customerID, point);
    }

    public Point getPointByCustomerId(CustomerID customerID) {
        Point point = customers.get(customerID);
        if (point == null) {
            throw new NoSuchElementException("CustomerID " + customerID + " not found in Customers.");
        }
        return point;
    }
}
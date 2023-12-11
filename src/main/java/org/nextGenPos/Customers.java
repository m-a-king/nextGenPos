package org.nextGenPos;

import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@NoArgsConstructor
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

    public void addPointByCustomerId(CustomerID customerID,Point point){
        Point currentPoint = customers.get(customerID);
        if (point == null) {
            throw new NoSuchElementException("CustomerID " + customerID + " not found in Customers.");
        }
        customers.replace(customerID,currentPoint.add(point));
    }

    public void minusPointByCustomerId(CustomerID customerID,Point point){
        Point currentPoint = customers.get(customerID);

        if (point == null) {
            throw new NoSuchElementException("CustomerID " + customerID + " not found in Customers.");
        }
        
        customers.replace(customerID,currentPoint.minus(point));
    }
}
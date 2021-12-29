package com.balabasciuc.design_patterns.BehavioralPatterns.CommandPattern.orderExample;

import java.util.ArrayList;
import java.util.List;

public class Broker {

    private List<Order> orderList = new ArrayList<>();

    public void takeOrder(Order takingOrder)
    {
        orderList.add(takingOrder);
    }

    public void placedOrders()
    {
        for (Order orders : orderList) {
            orders.execute();
        }
        orderList.clear();
    }
}

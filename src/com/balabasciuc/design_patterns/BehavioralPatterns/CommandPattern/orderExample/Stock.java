package com.balabasciuc.design_patterns.BehavioralPatterns.CommandPattern.orderExample;

public class Stock {

    private String stockName = "Product01";
    private int stockQuantity = 1;


    public void buy()
    {
        System.out.println("Stock: " + stockName + " was buying in the next quantity: " + stockQuantity);
    }

    public void sell()
    {
        System.out.println("Selling products... " + stockName + " with the quantity: " + stockQuantity);
    }
}

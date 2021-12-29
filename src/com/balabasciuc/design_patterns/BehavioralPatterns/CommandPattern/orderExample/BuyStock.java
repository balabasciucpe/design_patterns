package com.balabasciuc.design_patterns.BehavioralPatterns.CommandPattern.orderExample;

public class BuyStock implements Order {

    private Stock stock;

    public BuyStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void execute() {
        stock.buy();
    }
}

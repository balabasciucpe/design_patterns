package com.balabasciuc.design_patterns.BehavioralPatterns.StrategyPattern;

public class DuckMallard extends Duck {

    public DuckMallard() {
        quackBehaviour = new QuackLouder();
        flyBehaviour = new FlyWithWings();
    }

    @Override
    void display() {
        System.out.println("Inside DuckMallard class");
    }
}

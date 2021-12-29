package com.balabasciuc.design_patterns.StructuralPatterns.DecoratorPattern;

public class Espresso extends Beverage {

    public Espresso() {
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 0.99;
    }


}

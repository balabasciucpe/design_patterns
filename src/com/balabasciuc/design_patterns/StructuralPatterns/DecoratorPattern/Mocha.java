package com.balabasciuc.design_patterns.StructuralPatterns.DecoratorPattern;

public class Mocha  extends CondimentDecorator {

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " mocha";
    }

    @Override
    public double cost() {
        return beverage.cost() + .99;
    }


}

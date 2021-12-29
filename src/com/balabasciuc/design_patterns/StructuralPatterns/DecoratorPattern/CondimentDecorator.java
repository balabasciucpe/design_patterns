package com.balabasciuc.design_patterns.StructuralPatterns.DecoratorPattern;

public abstract class CondimentDecorator extends Beverage {

    Beverage beverage;

    public abstract String getDescription();

}

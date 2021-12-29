package com.balabasciuc.design_patterns.StructuralPatterns.DecoratorPattern;

public class HouseBlend extends Beverage {

    public HouseBlend() {
        description = "House Blend Caffe";
    }

    @Override
    public double cost() {
        return 2.33;
    }
}

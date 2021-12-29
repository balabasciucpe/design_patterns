package com.balabasciuc.design_patterns.StructuralPatterns.AdapterPattern;

public class MallardDuck implements Duck {

    @Override
    public void quack() {
        System.out.println("I m quacking!");
    }

    @Override
    public void fly() {
        System.out.println("I m flying!");
    }
}

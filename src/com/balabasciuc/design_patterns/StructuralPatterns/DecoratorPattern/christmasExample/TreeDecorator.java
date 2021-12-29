package com.balabasciuc.design_patterns.StructuralPatterns.DecoratorPattern.christmasExample;

public abstract class TreeDecorator implements ChristmasTree {

     ChristmasTree christmasTree;


    @Override
    public String decorate() {
        return christmasTree.decorate();
    }
}

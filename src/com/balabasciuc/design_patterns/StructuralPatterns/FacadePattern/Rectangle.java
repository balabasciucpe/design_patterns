package com.balabasciuc.design_patterns.StructuralPatterns.FacadePattern;

public class Rectangle implements Shape {


    @Override
    public void draw() {
        System.out.println("I'm a Rectangle in the drawing method");
    }
}

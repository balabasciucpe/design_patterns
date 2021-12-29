package com.balabasciuc.design_patterns.StructuralPatterns.FacadePattern;

public class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("I'm a Square in the drawing method!");
    }
}

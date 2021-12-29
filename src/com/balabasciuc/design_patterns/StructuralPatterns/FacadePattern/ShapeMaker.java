package com.balabasciuc.design_patterns.StructuralPatterns.FacadePattern;

public class ShapeMaker {

    private Shape rectangle;
    private Shape square;

    public ShapeMaker() {
        //Putem folosi Factory ca sa cream obj...
        this.rectangle = new Rectangle();
        this.square = new Square();
    }

    public void drawRectangle()
    {
        rectangle.draw();
    }

    public void drawSquare()
    {
        square.draw();
    }
}

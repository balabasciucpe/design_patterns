package com.balabasciuc.design_patterns.CreationalPatterns.FactoryPattern.AbstractFactory;

public class ComputerFactory {

    public static Computer getComputer(ComputerAbstractFactory factory)
    {
        return factory.createComputer();
    }
}

package com.balabasciuc.design_patterns.CreationalPatterns.FactoryPattern.AbstractFactory.animalExample;

public class FactoryProvider {

    public static AbstractFactory getFactory(String choice)
    {
        if(choice.equalsIgnoreCase("animal"))
        {
            return new AnimalFactory();
        }
        return null;
    }
}

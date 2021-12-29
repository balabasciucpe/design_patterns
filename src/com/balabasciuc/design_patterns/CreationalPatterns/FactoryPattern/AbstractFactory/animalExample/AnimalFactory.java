package com.balabasciuc.design_patterns.CreationalPatterns.FactoryPattern.AbstractFactory.animalExample;

public class AnimalFactory implements AbstractFactory<Animal> {

    @Override
    public Animal createType(String type) {
        if(type.equalsIgnoreCase("duck")) {
            return new Duck();
        }
            else if(type.equalsIgnoreCase("bear"))
        {
            return new Bear(); }
        else
            System.out.println("We don't have an " + type + " right now.");
            return null;
    }
}

package com.balabasciuc.design_patterns.CreationalPatterns.FactoryPattern.AbstractFactory.animalExample;

public class Bear implements Animal {

    public Bear() {
        System.out.println("A bear was created");
    }

    @Override
    public String getAnimal() {
        return "Bear";
    }

    @Override
    public void makeSound() {
        System.out.println("Mor Mor Mor");
    }
}

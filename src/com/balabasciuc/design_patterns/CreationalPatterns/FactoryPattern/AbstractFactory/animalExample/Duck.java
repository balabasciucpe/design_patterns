package com.balabasciuc.design_patterns.CreationalPatterns.FactoryPattern.AbstractFactory.animalExample;

public class Duck implements Animal {

    @Override
    public String getAnimal() {
        return "Duck";
    }

    @Override
    public void makeSound() {
        System.out.println("Quack Quack Quack");
    }
}

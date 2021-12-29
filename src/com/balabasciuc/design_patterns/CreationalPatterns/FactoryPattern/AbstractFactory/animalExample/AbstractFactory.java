package com.balabasciuc.design_patterns.CreationalPatterns.FactoryPattern.AbstractFactory.animalExample;

public interface AbstractFactory<T> {

     T createType(String type);
}

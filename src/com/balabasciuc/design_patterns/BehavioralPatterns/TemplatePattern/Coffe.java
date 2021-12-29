package com.balabasciuc.design_patterns.BehavioralPatterns.TemplatePattern;

public class Coffe extends CaffeineBeverage {

    @Override
    void brew() {
        System.out.println("Brewing with coffe in mind...");
    }

    @Override
    void addCondiments() {
        System.out.println("a little bit of coffeine, a little bit of sugar and that's it");
    }
}

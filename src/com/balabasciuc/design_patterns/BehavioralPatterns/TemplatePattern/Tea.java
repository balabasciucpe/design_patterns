package com.balabasciuc.design_patterns.BehavioralPatterns.TemplatePattern;

public class Tea extends CaffeineBeverage {

    @Override
    void brew() {
        System.out.println("Steeping the tea");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding lemon and sugar");
    }
}

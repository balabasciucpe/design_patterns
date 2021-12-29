package com.balabasciuc.design_patterns.BehavioralPatterns.TemplatePattern.HookExample;

public class CoffeWithHook extends CaffeineBeverageWithHook {

    @Override
    void brew() {
        System.out.println("Brewing coffe.");
    }

    @Override
    void addCondimentsToTheClients() {
        System.out.println("Sugar and milk was added.");
    }
}

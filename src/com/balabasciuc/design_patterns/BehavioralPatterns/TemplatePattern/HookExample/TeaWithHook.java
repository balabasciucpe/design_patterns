package com.balabasciuc.design_patterns.BehavioralPatterns.TemplatePattern.HookExample;

public class TeaWithHook extends CaffeineBeverageWithHook {

    @Override
    void brew() {
        System.out.println("brew for tea");
    }

    @Override
    boolean customerWantsCondiments() {
        return false;
    }

    @Override
    void addCondimentsToTheClients() {

    }
}

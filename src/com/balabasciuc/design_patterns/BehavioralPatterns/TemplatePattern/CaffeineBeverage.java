package com.balabasciuc.design_patterns.BehavioralPatterns.TemplatePattern;

public abstract class CaffeineBeverage {

    public final void prepareRecipe()
    {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    public void boilWater()
    {
        System.out.println("Boiling water!");
    }

    abstract void brew();

    public void pourInCup()
    {
        System.out.println("Pouring into cup");
    }

    abstract void addCondiments();
}

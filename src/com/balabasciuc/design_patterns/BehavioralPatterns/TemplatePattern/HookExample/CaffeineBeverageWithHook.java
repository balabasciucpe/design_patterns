package com.balabasciuc.design_patterns.BehavioralPatterns.TemplatePattern.HookExample;

public abstract class CaffeineBeverageWithHook {

    public final void prepareRecipe()
    {
        boilWater();
        brew();
        pourInCup();
        if(customerWantsCondiments())
        {
            addCondimentsToTheClients();
        }
    }

    public void boilWater()
    {
        System.out.println("Boiling water.....");
    }

    abstract void brew();

    public void pourInCup()
    {
        System.out.println("Pouring in cup");
    }

    abstract void addCondimentsToTheClients();

    boolean customerWantsCondiments()
    {
        return true;
    }



}

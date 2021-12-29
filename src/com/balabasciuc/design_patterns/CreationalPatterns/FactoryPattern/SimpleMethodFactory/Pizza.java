package com.balabasciuc.design_patterns.CreationalPatterns.FactoryPattern.SimpleMethodFactory;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {

    private String pizzaName;
    private String pizzaDough;
    private String pizzaSauce;

    private List<String> toppings = new ArrayList<String>();

    public String getPizzaName() {
        return pizzaName;
    }

    public void preparePizza()
    {
        System.out.println("Preparing pizza... " + pizzaName);
    }

    public void bakePizza()
    {
        System.out.println("Baking pizza... ");
    }

    public void cutPizza()
    {
        System.out.println("Cutting pizza... "  + pizzaName);
    }

    public void boxPizza()
    {
        System.out.println("Boxing pizza... "  + pizzaName);
    }
}

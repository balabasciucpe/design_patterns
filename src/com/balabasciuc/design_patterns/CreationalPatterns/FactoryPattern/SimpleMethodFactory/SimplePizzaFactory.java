package com.balabasciuc.design_patterns.CreationalPatterns.FactoryPattern.SimpleMethodFactory;

public class SimplePizzaFactory {

    public Pizza createPizza(String pizzaType)
    {
        Pizza pizza = null;
        if(pizzaType.equalsIgnoreCase("cheese"))
        {
            pizza = new CheesePizza();
        }

        // and so on...

        return pizza;
    }
}

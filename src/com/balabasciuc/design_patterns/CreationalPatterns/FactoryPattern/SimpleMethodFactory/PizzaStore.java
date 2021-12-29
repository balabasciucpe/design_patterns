package com.balabasciuc.design_patterns.CreationalPatterns.FactoryPattern.SimpleMethodFactory;

public class PizzaStore {

    private SimplePizzaFactory simplePizzaFactory;

    public PizzaStore(SimplePizzaFactory simplePizzaFactory) {
        this.simplePizzaFactory = simplePizzaFactory;
    }

    public Pizza createPizza(String pizzaType)
    {
        Pizza pizza;
        pizza = simplePizzaFactory.createPizza(pizzaType);
        pizza.preparePizza();
        pizza.bakePizza();
        pizza.cutPizza();
        pizza.boxPizza();

        return pizza;
    }
}

package com.balabasciuc.design_patterns.BehavioralPatterns.StrategyPattern;

public abstract class Duck {

    FlyBehaviour flyBehaviour;
    QuackBehaviour quackBehaviour;

    public void setFlyBehaviour(FlyBehaviour flyBehaviour) {
        this.flyBehaviour = flyBehaviour;
    }

    public void setQuackBehaviour(QuackBehaviour quackBehaviour) {
        this.quackBehaviour = quackBehaviour;
    }

    public void performFly()
    {
        flyBehaviour.fly();
    }

    public void quackBehaviour()
    {
        quackBehaviour.quack();
    }

    abstract void display();
}

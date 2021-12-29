package com.balabasciuc.design_patterns.CompoundPattern;

public class CountingDuckFactory extends AbstractDuckFactory {

    @Override
    public Quackable createMallardDuck() {
        return new QuackCounterDecorator(new MallardDuck());
    }

    @Override
    public Quackable createRedHeadDuck() {
        return new QuackCounterDecorator(new RedHeadDuck());
    }

    @Override
    public Quackable createRubberDuck() {
        return new QuackCounterDecorator(new RubberDuck());
    }
}

package com.balabasciuc.design_patterns.CompoundPattern;

public class DuckFactory extends AbstractDuckFactory {

    @Override
    public Quackable createMallardDuck() {
        return new MallardDuck();
    }

    @Override
    public Quackable createRedHeadDuck() {
        return new RedHeadDuck();
    }

    @Override
    public Quackable createRubberDuck() {
        return new RubberDuck();
    }
}

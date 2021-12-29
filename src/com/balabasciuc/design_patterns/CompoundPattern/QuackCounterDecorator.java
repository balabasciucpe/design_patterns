package com.balabasciuc.design_patterns.CompoundPattern;

public class QuackCounterDecorator implements Quackable {

    private Quackable quackable;
    private static int quackCounter;

    public QuackCounterDecorator(Quackable quackable) {
        this.quackable = quackable;
    }

    @Override
    public void quack() {
        quackable.quack();
        quackCounter++;
    }

    public static int getQuackCounter() {
        return quackCounter;
    }

    @Override
    public void registerObservable(Observer observer) {
        quackable.registerObservable(observer);
    }

    @Override
    public void notifyObservers() {
        quackable.notifyObservers();
    }
}

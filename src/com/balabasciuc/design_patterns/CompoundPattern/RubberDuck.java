package com.balabasciuc.design_patterns.CompoundPattern;

public class RubberDuck implements Quackable {

    private Observable observable;

    public RubberDuck() {
        this.observable = new Observable(this);
    }

    @Override
    public void quack() {
        System.out.println("Squeak");
    }

    @Override
    public void registerObservable(Observer observer) {
        observable.registerObservable(observer);
    }

    @Override
    public void notifyObservers() {
        observable.notifyObservers();
    }
}

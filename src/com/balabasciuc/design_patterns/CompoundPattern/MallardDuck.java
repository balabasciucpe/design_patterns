package com.balabasciuc.design_patterns.CompoundPattern;

public class MallardDuck implements Quackable {

    private Observable observable;

    public MallardDuck() {
        this.observable = new Observable(this);
    }

    @Override
    public void quack() {
        System.out.println("Quack!");
        notifyObservers();
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

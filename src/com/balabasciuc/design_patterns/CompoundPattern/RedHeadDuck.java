package com.balabasciuc.design_patterns.CompoundPattern;

public class RedHeadDuck implements Quackable {

    private Observable observable;

    public RedHeadDuck() {
        this.observable = new Observable(this);
    }

    @Override
    public void quack() {
        System.out.println("Quack");
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

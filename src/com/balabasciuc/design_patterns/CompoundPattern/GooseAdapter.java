package com.balabasciuc.design_patterns.CompoundPattern;

public class GooseAdapter implements Quackable {

    private Goose goose;
    private Observable observable;

    public GooseAdapter(Goose goose) {
        this.goose = goose;
        this.observable = new Observable(this);
    }

    @Override
    public void quack() {
        goose.honk();
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

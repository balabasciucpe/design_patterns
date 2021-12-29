package com.balabasciuc.design_patterns.CompoundPattern;

public class Quackologist implements Observer {

    @Override
    public void update(QuackObservable quackObservable) {
        System.out.println("Duck just " + quackObservable);
    }

    @Override
    public String toString() {
        return "Quackologist{}";
    }
}

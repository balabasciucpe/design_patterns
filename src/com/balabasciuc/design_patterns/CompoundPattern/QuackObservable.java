package com.balabasciuc.design_patterns.CompoundPattern;

public interface QuackObservable {

    public void registerObservable(Observer observer);
    public void notifyObservers();

}

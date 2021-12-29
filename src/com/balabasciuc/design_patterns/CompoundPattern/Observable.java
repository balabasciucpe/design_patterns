package com.balabasciuc.design_patterns.CompoundPattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Observable implements QuackObservable {

    List<com.balabasciuc.design_patterns.CompoundPattern.Observer> observerList = new ArrayList<>();
    QuackObservable quackObservable;

    public Observable(QuackObservable quackObservable) {
        this.quackObservable = quackObservable;
    }

    @Override
    public void registerObservable(com.balabasciuc.design_patterns.CompoundPattern.Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void notifyObservers() {
        Iterator<Observer> notifyObservers = observerList.iterator();
        while(notifyObservers.hasNext())
        {
            Observer observer = notifyObservers.next();
            observer.update(quackObservable);
        }
    }
}

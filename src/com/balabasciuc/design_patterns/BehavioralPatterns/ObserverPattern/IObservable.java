package com.balabasciuc.design_patterns.BehavioralPatterns.ObserverPattern;

public interface IObservable {

    void addObserver(IObserve iObserve);
    void removeObserver(IObserve iObserve);
    void notifyObservers();
}

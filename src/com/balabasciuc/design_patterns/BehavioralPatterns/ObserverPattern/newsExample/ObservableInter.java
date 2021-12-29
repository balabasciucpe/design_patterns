package com.balabasciuc.design_patterns.BehavioralPatterns.ObserverPattern.newsExample;



public interface ObservableInter {

    void addObserver(IObserver iObserver);
    void removeObserver(IObserver iObserver);
    void notifyObservers();
}

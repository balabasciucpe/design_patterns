package com.balabasciuc.design_patterns.BehavioralPatterns.StatePattern;

public interface State {

    void insertQuarter();
    void ejectQuarter();
    void turnCrank();
    void dispense();
    void refill();
}

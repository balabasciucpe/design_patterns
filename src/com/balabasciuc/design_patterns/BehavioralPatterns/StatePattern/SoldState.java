package com.balabasciuc.design_patterns.BehavioralPatterns.StatePattern;

public class SoldState implements State {

    private GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {

    }

    @Override
    public void ejectQuarter() {

    }

    @Override
    public void turnCrank() {

    }

    @Override
    public void dispense() {
        gumballMachine.releaseBall();
        if(gumballMachine.getNumberOfGumballs() > 0)
        {
            gumballMachine.setState(gumballMachine.getNoQuarterState());
        }
        else
        {
            gumballMachine.setState(gumballMachine.getSoldOutState());
        }
    }

    @Override
    public void refill() {

    }
}

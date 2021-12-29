package com.balabasciuc.design_patterns.BehavioralPatterns.StatePattern;

public class SoldOutState implements State {

    private GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("no more quarters allowed for this moment");
    }

    @Override
    public void ejectQuarter() {

    }

    @Override
    public void turnCrank() {

    }

    @Override
    public void dispense() {

    }

    @Override
    public void refill() {
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }
}

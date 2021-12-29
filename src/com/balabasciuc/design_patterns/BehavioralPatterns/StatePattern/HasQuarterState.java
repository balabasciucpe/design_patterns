package com.balabasciuc.design_patterns.BehavioralPatterns.StatePattern;

public class HasQuarterState implements State {

    private GumballMachine gumballMachine;

    public HasQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You can't insert another quarter! ");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Be carefull next time");
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }

    @Override
    public void turnCrank() {
        System.out.println("Turning crank in the HasQuarterState");
        gumballMachine.setState(gumballMachine.getSoldState());
    }

    @Override
    public void dispense() {

    }

    @Override
    public void refill() {

    }


}

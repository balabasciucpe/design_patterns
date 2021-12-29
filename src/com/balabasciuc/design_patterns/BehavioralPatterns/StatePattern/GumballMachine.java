package com.balabasciuc.design_patterns.BehavioralPatterns.StatePattern;

public class GumballMachine {

    private State soldOutState;
    private State noQuarterState;
    private State hasQuarterState;
    private State soldState;

    private State state;
    private int numberOfGumballs;

    public GumballMachine(int numberOfGumballs) {

        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        this.numberOfGumballs = numberOfGumballs;
        checkForNumberOfGumballsImput();
    }

    private void checkForNumberOfGumballsImput() {
        if (numberOfGumballs > 0) {
            state = noQuarterState;
        } else {
            state = soldOutState;
        }
    }

    public void insertQuarter() {
        state.insertQuarter();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    public void releaseBall() {
        System.out.println("A gumball comes rolling out the slot... ");
        if (numberOfGumballs > 0) {
            numberOfGumballs--;
        }
    }

    public void refillNumberOfGumblles(int numberOfGumballsRefill)
    {
        this.numberOfGumballs += numberOfGumballsRefill;
        System.out.println("Machine was refilled, new inventory is " + this.numberOfGumballs);
        state.refill();
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getSoldState() {
        return soldState;
    }

    public State getState() {
        return state;
    }

    public int getNumberOfGumballs() {
        return numberOfGumballs;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "GumballMachine{" +
                "state=" + state +
                '}';
    }
}

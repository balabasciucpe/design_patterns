package com.balabasciuc.design_patterns.BehavioralPatterns.StrategyPattern;

public class FlyWithWings implements FlyBehaviour {


    @Override
    public void fly() {
        System.out.println("I'm flying!");
    }
}

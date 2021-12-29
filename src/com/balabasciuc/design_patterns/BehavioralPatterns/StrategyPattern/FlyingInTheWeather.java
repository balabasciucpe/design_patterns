package com.balabasciuc.design_patterns.BehavioralPatterns.StrategyPattern;

public class FlyingInTheWeather implements FlyBehaviour {

    @Override
    public void fly() {
        System.out.println("I m flying in the weather!");
    }
}

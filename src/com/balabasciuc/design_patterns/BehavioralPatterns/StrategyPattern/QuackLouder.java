package com.balabasciuc.design_patterns.BehavioralPatterns.StrategyPattern;

public class QuackLouder implements QuackBehaviour {


    @Override
    public void quack() {
        System.out.println("QUACK QUACK QUACK");
    }
}

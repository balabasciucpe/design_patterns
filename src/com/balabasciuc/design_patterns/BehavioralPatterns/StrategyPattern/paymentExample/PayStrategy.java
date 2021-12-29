package com.balabasciuc.design_patterns.BehavioralPatterns.StrategyPattern.paymentExample;

//abstract strategy -> impl: concrete strategy -> perform the actual business logic but also alter the behaviour of different classes at runtime
public interface PayStrategy {

    boolean pay(int paymentAmount);
    void collectPaymentDetails();



}

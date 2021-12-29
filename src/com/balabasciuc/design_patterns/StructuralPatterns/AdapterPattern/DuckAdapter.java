package com.balabasciuc.design_patterns.StructuralPatterns.AdapterPattern;

public class DuckAdapter implements Turkey {

    private Duck duck;


    public DuckAdapter(Duck duck) {
        this.duck = duck;
    }

    @Override
    public void glugluglu() {
        duck.quack();
    }

    @Override
    public void fly() {
        duck.fly();
    }
}

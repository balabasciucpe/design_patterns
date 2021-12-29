package com.balabasciuc.design_patterns.StructuralPatterns.AdapterPattern;

public class TurkeyAdapter implements Duck {

    private Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.glugluglu();
    }

    @Override
    public void fly() {
        for(int i = 0; i <= 5; i++)
        {
            turkey.fly();
        }
    }
}

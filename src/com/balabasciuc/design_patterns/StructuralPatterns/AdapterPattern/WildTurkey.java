package com.balabasciuc.design_patterns.StructuralPatterns.AdapterPattern;

public class WildTurkey implements Turkey {


    @Override
    public void glugluglu() {
        System.out.println("glu glu glu");
    }

    @Override
    public void fly() {
        System.out.println("can t really fly...");
    }
}

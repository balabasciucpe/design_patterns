package com.balabasciuc.design_patterns.CreationalPatterns.FactoryPattern.MethodFactory;

public class RATBilet extends Bilet {

    @Override
    public Double getBiletCost() {
        return 0.99;
    }
}

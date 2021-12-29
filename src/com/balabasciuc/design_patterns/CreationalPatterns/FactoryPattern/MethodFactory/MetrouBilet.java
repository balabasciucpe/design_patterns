package com.balabasciuc.design_patterns.CreationalPatterns.FactoryPattern.MethodFactory;

public class MetrouBilet extends Bilet {

    public MetrouBilet() {
        System.out.println("Biletul pentru metrou a fost emis si va costa " + getBiletCost());
        //putem pune garzi sa vedem daca are bani destui etc
    }

    @Override
    public Double getBiletCost() {
        return 2.99;
    }
}

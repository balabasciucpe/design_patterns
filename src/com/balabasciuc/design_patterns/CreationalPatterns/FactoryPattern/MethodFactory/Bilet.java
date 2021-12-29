package com.balabasciuc.design_patterns.CreationalPatterns.FactoryPattern.MethodFactory;

public abstract class Bilet {

    private String biletDestinatie;
    private Double biletCost;

    public abstract Double getBiletCost();

    public void biletEmis()
    {
        System.out.println("Biletul a fost emis!");
    }

}

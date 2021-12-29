package com.balabasciuc.design_patterns.CreationalPatterns.FactoryPattern.MethodFactory;

public abstract class Autobuz {

    public Bilet emitereBilet(String destinatieBilet)
    {
        Bilet bilet;
        bilet = emitereBiletAutobuz(destinatieBilet);

        bilet.biletEmis();
        bilet.getBiletCost();
        return bilet;
    }


    abstract Bilet emitereBiletAutobuz(String emitereDestinatieBilet);
}

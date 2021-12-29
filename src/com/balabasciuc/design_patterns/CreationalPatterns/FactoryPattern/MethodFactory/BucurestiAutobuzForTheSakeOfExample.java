package com.balabasciuc.design_patterns.CreationalPatterns.FactoryPattern.MethodFactory;

public class BucurestiAutobuzForTheSakeOfExample extends Autobuz {

    @Override
    Bilet emitereBiletAutobuz(String emitereDestinatieBilet) {
        if (emitereDestinatieBilet.equals("Gara"))
        {
            return new RATBilet();
        }
        else if(emitereDestinatieBilet.equalsIgnoreCase("aeroport"))
        {
            return new MetrouBilet();
        }
        else return null;
        //nullPointerException......... ai grija de asta
    }
}

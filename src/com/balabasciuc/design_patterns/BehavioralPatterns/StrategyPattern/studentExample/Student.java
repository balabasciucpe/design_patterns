package com.balabasciuc.design_patterns.BehavioralPatterns.StrategyPattern.studentExample;

public abstract class Student {


    //Algoritmi ce variaza si pot schimba comportamentul in runtime
    TipDeSomn tipDeSomn;
    ModDeInvatare modDeInvatare;

    public void setTipDeSomn(TipDeSomn tipDeSomn) {
        this.tipDeSomn = tipDeSomn;
    }

    public void setModDeInvatare(ModDeInvatare modDeInvatare) {
        this.modDeInvatare = modDeInvatare;
    }

    public void dormi()
    {
        tipDeSomn.ceSomnDoresti();
    }

    public void invat()
    {
        modDeInvatare.cumInveti();
    }
    //algoritmi/comportament/metode ce nu variaza, specifice Studentului


}

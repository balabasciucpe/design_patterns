package com.balabasciuc.design_patterns.BehavioralPatterns.StrategyPattern.discountExample;

import java.math.BigDecimal;

public class EasternDiscounter implements Discounter {


    //final ca sa nu mai putem schimba apoi discount-ul, ci e unul fix pt. Paste
    @Override
    public BigDecimal applyDiscount(final BigDecimal amount) {

        return amount.multiply(BigDecimal.valueOf(0.5));
    }
}

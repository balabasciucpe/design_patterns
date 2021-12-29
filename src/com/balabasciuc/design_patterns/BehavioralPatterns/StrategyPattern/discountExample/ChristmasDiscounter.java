package com.balabasciuc.design_patterns.BehavioralPatterns.StrategyPattern.discountExample;

import java.math.BigDecimal;

public class ChristmasDiscounter implements Discounter {

    @Override
    public BigDecimal applyDiscount(final BigDecimal amount) {
        return amount.multiply(BigDecimal.valueOf(0.9));
    }



}

package com.balabasciuc.design_patterns.BehavioralPatterns.StrategyPattern.discountExample;

import java.math.BigDecimal;

public interface Discounter {

    BigDecimal applyDiscount(BigDecimal amount);


}

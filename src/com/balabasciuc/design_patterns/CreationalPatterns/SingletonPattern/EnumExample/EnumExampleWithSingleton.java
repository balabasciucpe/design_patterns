package com.balabasciuc.design_patterns.CreationalPatterns.SingletonPattern.EnumExample;

//not allow lazy init
public enum EnumExampleWithSingleton {

    INSTANCE;

    public String enumDescription()
    {
       return "hello from thread safe Enum!";
    }
}

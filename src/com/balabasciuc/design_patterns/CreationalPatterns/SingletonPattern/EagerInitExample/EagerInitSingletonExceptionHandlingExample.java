package com.balabasciuc.design_patterns.CreationalPatterns.SingletonPattern.EagerInitExample;

//not recommaned -> eager init -> consume resources...
public class EagerInitSingletonExceptionHandlingExample {

    private static EagerInitSingletonExceptionHandlingExample INSTANCE;

    private EagerInitSingletonExceptionHandlingExample() {}

    static
    {
        try
        {
            INSTANCE = new EagerInitSingletonExceptionHandlingExample();
        }
        catch(Exception e)
        {
            throw new RuntimeException("Exception occured in creating singleton instance");
        }
    }

    public static EagerInitSingletonExceptionHandlingExample getINSTANCE() {
        return INSTANCE;
    }
}

package com.balabasciuc.design_patterns.CreationalPatterns.SingletonPattern.EagerInitExample;

//for eager init != recommanded...
//we don t cover the exception handling...
//consume resources
public class EagerInitSingletonExample {

    private static final EagerInitSingletonExample INSTANCE = new EagerInitSingletonExample();

    private EagerInitSingletonExample() {}

    public static EagerInitSingletonExample getINSTANCE() {
        return INSTANCE;
    }
}

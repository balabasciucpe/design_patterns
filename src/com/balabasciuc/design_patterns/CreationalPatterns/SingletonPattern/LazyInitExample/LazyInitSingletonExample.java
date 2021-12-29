package com.balabasciuc.design_patterns.CreationalPatterns.SingletonPattern.LazyInitExample;

public class LazyInitSingletonExample {

    private static LazyInitSingletonExample INSTANCE;

    private LazyInitSingletonExample() {}

    //use synchronized for thread safe but it s time consuming
    public static LazyInitSingletonExample getInstance()
    {
        if(INSTANCE == null)
        {
            INSTANCE = new LazyInitSingletonExample();
        }

        return INSTANCE;
    }

    /*
    double checking locking for thread safe:
    public static LazyInitSingletonExample getInstanceDoubleLocking()
    {
    if(INSTANCE == null){
        synchronized (LazyInitSingletonExample.class)
            {
            if(INSTANCE == null)
                {INSTANCE = new LazyInitSingletonExample(); }
            }
    }
        return INSTANCE;
        }
     */
}

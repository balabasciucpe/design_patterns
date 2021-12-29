package com.balabasciuc.design_patterns.BehavioralPatterns.IteratorPattern;

import java.util.Iterator;

public interface Menu {

    public Iterator<?> createIterator();
}

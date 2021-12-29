package com.balabasciuc.design_patterns.CompoundPattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FlockComposite implements Quackable {

    List<Quackable> quackableList = new ArrayList<>();

    public void add(Quackable quackable)
    {
        quackableList.add(quackable);
    }

    @Override
    public void quack() {

        Iterator<Quackable> iterator = quackableList.iterator();
        while(iterator.hasNext())
        {
            Quackable quackable = iterator.next();
            quackable.quack();
        }
    }

    @Override
    public void registerObservable(Observer observer) {
        Iterator<Quackable> iterator = quackableList.iterator();
        while(iterator.hasNext())
        {
            Quackable duck = (Quackable) iterator.next();
            duck.registerObservable(observer);
        }
    }

    @Override
    public void notifyObservers() {

    }

    @Override
    public String toString() {
        return "FlockComposite{" +
                "quackableList=" + quackableList +
                '}';
    }
}

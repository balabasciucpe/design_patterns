package com.balabasciuc.design_patterns.BehavioralPatterns.IteratorPattern;

import java.util.Iterator;
import java.util.function.Consumer;

public class DinnerMenuIterator implements Iterator<MenuItem> {

    MenuItem[] list;
    int pozitie;

    public DinnerMenuIterator(MenuItem[] list) {
        this.list = list;
    }

    @Override
    public void remove() {
        if(pozitie <= 0)
        {
            throw new IllegalStateException("You can't do that");
        }
    }



    @Override
    public boolean hasNext() {
        if(pozitie >= list.length || list[pozitie] == null)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    @Override
    public MenuItem next() {
        MenuItem menuItem = list[pozitie];
        pozitie++;
        return menuItem;
    }
}

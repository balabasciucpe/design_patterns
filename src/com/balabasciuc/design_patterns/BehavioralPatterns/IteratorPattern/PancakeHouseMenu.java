package com.balabasciuc.design_patterns.BehavioralPatterns.IteratorPattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PancakeHouseMenu implements Menu {

    private List<MenuItem> menuItemList;

    public PancakeHouseMenu()
    {
        menuItemList = new ArrayList<>();
        addToMenuItemList("Amandina", "are ciocolata", false, 2.00);
        addToMenuItemList("ABC", "prajitura secreta", true, 3.99);
    }

    public void addToMenuItemList(String name, String description, boolean vegetarian, double price)
    {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuItemList.add(menuItem);
    }



    @Override
    public Iterator<MenuItem> createIterator() {
        return menuItemList.iterator();
    }
}

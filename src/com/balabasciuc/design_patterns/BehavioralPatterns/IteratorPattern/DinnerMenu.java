package com.balabasciuc.design_patterns.BehavioralPatterns.IteratorPattern;

import java.util.Iterator;

public class DinnerMenu implements Menu {

    static final int MAX_ITEMS = 6;
    int numberOfItems = 0;
    MenuItem[] menuItems;

    public DinnerMenu()
    {
        menuItems = new MenuItem[MAX_ITEMS];

        addItem("hamburger", "bunbunbunbun", false, 4.03);
        addItem("cereale", "bune pentru sanatate", true, 2.00);
    }

    public void addItem(String name, String description, boolean vegetarian, double price)
    {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        if(numberOfItems >= MAX_ITEMS)
        {
            System.err.println("Menu is full!");
        }
        else
        {
            menuItems[numberOfItems] = menuItem;
            numberOfItems++;
        }
    }

    @Override
    public Iterator<MenuItem> createIterator() {
        return new DinnerMenuIterator(menuItems);
    }
}

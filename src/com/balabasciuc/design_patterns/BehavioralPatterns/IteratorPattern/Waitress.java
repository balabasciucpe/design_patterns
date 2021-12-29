package com.balabasciuc.design_patterns.BehavioralPatterns.IteratorPattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Waitress {


    private List<Menu> menuList;

    public Waitress(ArrayList<Menu> menuList) {
        this.menuList = menuList;
    }

    public void printMenu()
    {
        Iterator<?> menuItem = menuList.iterator();
        while(menuItem.hasNext())
        {
            Menu menus = (Menu) menuItem.next();
            printMenu(menus.createIterator());
        }
    }

    private void printMenu(Iterator<?> menuItemIterator){
        while(menuItemIterator.hasNext())
        {
            MenuItem menuItem = (MenuItem) menuItemIterator.next();
            System.out.println(menuItem.getName());
            System.out.println(menuItem.getDescription());
            System.out.println(menuItem.getPrice());
            System.out.println(menuItem.isVegetarian());
        }
    }

    public void printVegetarianMenu()
    {
        System.out.println("Vegetarian menu: ");
        Iterator<?> menuItem = menuList.iterator();
        while(menuItem.hasNext())
        {
            Menu menus = (Menu) menuItem.next();
            printVegetarianMenu(menus.createIterator());
        }
    }

    private void printVegetarianMenu(Iterator<?> vegetarianMenu)
    {
        while(vegetarianMenu.hasNext())
        {
            MenuItem menuItems = (MenuItem) vegetarianMenu.next();
            if(menuItems.isVegetarian())
            {
                System.out.println(menuItems.getName() + " " + menuItems.getPrice());
            }
        }
    }

    public boolean isThisItemVegetarian(String itemName)
    {
        Iterator<?> menuItem = menuList.iterator();
        if(isVegetarian(itemName, menuItem))
        {
            return true;
        }
        return false;
    }

    private boolean isVegetarian(String name, Iterator<?> iterator)
    {
        while(iterator.hasNext())
        {
            MenuItem menuItem = (MenuItem) iterator.next();
            if(menuItem.getName().equalsIgnoreCase(name))
            {
                if(menuItem.isVegetarian())
                {
                    return true;
                }
            }
        }
        return false;
    }


}

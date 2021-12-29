package com.balabasciuc.design_patterns.StructuralPatterns.ProxyPattern.ProtectionProxy;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class ProxyPerson {

    Map<String, Person> dataBaseSimulation = new HashMap<>();

    public ProxyPerson() {
        initializeDB();
    }

    public void drive()
    {
        Person joe = getPersonFromDB("JoyBoy");
        Person ownerProxy = getOwnerPerson(joe);
        System.out.println("Name is " + ownerProxy.getName());
        ownerProxy.setInterests("bowling");
        System.out.println("Interests set from owner proxy");
        try {
            ownerProxy.setGeekRating(10);
        } catch (Exception e) {
            System.out.println("Can t set rating from owner Proxy"); }
        System.out.println("Rating is " + ownerProxy.getGeekRating());

        Person nonOwnerProxy = getNonOwnerPerson(joe);
        System.out.println("Name is " + nonOwnerProxy.getName());
        try
        {
            nonOwnerProxy.setInterests("java, al");
        } catch (Exception e) {
            System.out.println("Can t set interest from non owner Proxy");
        }
        nonOwnerProxy.setGeekRating(3);
        System.out.println("Geek rating was set from non owner proxy");
        System.out.println("Geeking is " + nonOwnerProxy.getGeekRating());
    }

    Person getOwnerPerson(Person person)
    {
        return (Person) Proxy.newProxyInstance(person.getClass().getClassLoader(), person.getClass().getInterfaces(), new OwnerInvocationHandler(person));
    }

    Person getNonOwnerPerson(Person person)
    {
        return (Person) Proxy.newProxyInstance(person.getClass().getClassLoader(),
                person.getClass().getInterfaces(), new NonOwnerInvocationHandler(person));
    }

    Person getPersonFromDB(String personName)
    {
        return dataBaseSimulation.get(personName);
    }

    private void initializeDB()
    {
        Person joe = new PersonImpl(); //factory...
        joe.setName("JoyBoy");
        joe.setInterests("cars, music, computers");
        joe.setGeekRating(9);
        dataBaseSimulation.put(joe.getName(), joe);

        Person chloe = new PersonImpl();
        chloe.setName("ChloeGirl");
        chloe.setInterests("movies, music");
        chloe.setGeekRating(7);
        dataBaseSimulation.put(chloe.getName(), chloe);
    }
}

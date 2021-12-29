package com.balabasciuc.design_patterns.StructuralPatterns.ProxyPattern.ProtectionProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class OwnerInvocationHandler implements InvocationHandler {

    private Person person;

    public OwnerInvocationHandler(Person person) {
        this.person = person;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try
        {
            if(method.getName().startsWith("get"))
            {
                return method.invoke(person, args);
            }
            else if(method.getName().equals("setGeekRating"))
            {
                throw new IllegalAccessException();
            }
            else if(method.getName().equalsIgnoreCase("set"))
            {
                return method.invoke(person, args);
            }
        } catch(InvocationTargetException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
}

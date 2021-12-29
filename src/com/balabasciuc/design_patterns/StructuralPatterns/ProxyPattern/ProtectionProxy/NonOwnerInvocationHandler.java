package com.balabasciuc.design_patterns.StructuralPatterns.ProxyPattern.ProtectionProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class NonOwnerInvocationHandler implements InvocationHandler {

    private Person person;

    public NonOwnerInvocationHandler(Person person) {
        this.person = person;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try
        {
            if(method.getName().startsWith("set"))
            {
                return new IllegalAccessException();
            }
            else if(method.getName().equals("setGeekRaking"))
            {
                return method.invoke(person, args);
            }
            else if(method.getName().startsWith("get"))
            {
                return method.invoke(person, args);
            }
        } catch(InvocationTargetException e) { e.printStackTrace(); }
        return null;
    }

}

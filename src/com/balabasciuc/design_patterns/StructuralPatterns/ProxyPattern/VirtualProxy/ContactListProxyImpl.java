package com.balabasciuc.design_patterns.StructuralPatterns.ProxyPattern.VirtualProxy;

import java.util.List;

//Lazy Loanding
public class ContactListProxyImpl implements ContactList {

    private ContactList contactList;


    @Override
    public List<Employee> getEmployeeList() {
        if(contactList == null)
        {
            System.out.println("Creating contact List and fetching List of Employees");
            contactList = new ContactListImpl();
        }
        return contactList.getEmployeeList();
    }
}

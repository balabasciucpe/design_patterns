package com.balabasciuc.design_patterns.StructuralPatterns.ProxyPattern.VirtualProxy;

import java.util.ArrayList;
import java.util.List;

public class ContactListImpl implements ContactList {

    @Override
    public List<Employee> getEmployeeList() {
        return getEmpList();
    }

    private static List<Employee> getEmpList()
    {
        List<Employee> employeeList = new ArrayList<>(2);
        employeeList.add(new Employee("NameTest01", 200.0));
        employeeList.add(new Employee("NameTest02", 3123.03));
        return employeeList;
    }
}

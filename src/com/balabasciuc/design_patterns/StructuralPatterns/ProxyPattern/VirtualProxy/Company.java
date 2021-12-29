package com.balabasciuc.design_patterns.StructuralPatterns.ProxyPattern.VirtualProxy;

public class Company {

    private String companyName;
    private String companyAddress;
    private ContactList contactList;

    public Company(String companyName, String companyAddress, ContactList contactList) {
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.contactList = contactList;

        System.out.println("Company Object created!");
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public ContactList getContactList() {
        return contactList;
    }
}

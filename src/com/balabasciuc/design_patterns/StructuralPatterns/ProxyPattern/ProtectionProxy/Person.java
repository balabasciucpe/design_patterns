package com.balabasciuc.design_patterns.StructuralPatterns.ProxyPattern.ProtectionProxy;

public interface Person {

    String getName();
    String getGender();
    String getInterests();
    int getGeekRating();

    void setName(String personName);
    void setGender(String personGender);
    void setInterests(String personInterests);
    void setGeekRating(int geekRating);
}

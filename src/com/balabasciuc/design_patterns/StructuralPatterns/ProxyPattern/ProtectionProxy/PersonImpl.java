package com.balabasciuc.design_patterns.StructuralPatterns.ProxyPattern.ProtectionProxy;

public class PersonImpl implements Person {

    private String name;
    private String gender;
    private String interests;
    private int rating;
    private int ratingCount = 0;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public String getInterests() {
        return interests;
    }

    @Override
    public int getGeekRating() {
        if(ratingCount == 0)
            return 0;
        return (rating / ratingCount);
    }

    @Override
    public void setName(String personName) {
        this.name = personName;
    }

    @Override
    public void setGender(String personGender) {
        this.gender = personGender;
    }

    @Override
    public void setInterests(String personInterests) {
        this.interests = personInterests;
    }

    @Override
    public void setGeekRating(int geekRating) {
        this.rating += geekRating;
        ratingCount++;
    }
}

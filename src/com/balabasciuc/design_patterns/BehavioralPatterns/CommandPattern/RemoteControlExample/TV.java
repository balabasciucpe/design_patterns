package com.balabasciuc.design_patterns.BehavioralPatterns.CommandPattern.RemoteControlExample;

public class TV {

    private String tvLocation;
    private int tvChannel;

    public TV(String tvLocation) {
        this.tvLocation = tvLocation;
    }

    public void on()
    {
        System.out.println("TV has started!");
    }

    public void off()
    {
        System.out.println("TV is shutting down...");
    }

    public void setInputChannel()
    {
        this.tvChannel = 3;
        System.out.println(tvLocation + " TV is set for DVD use...");
    }
}

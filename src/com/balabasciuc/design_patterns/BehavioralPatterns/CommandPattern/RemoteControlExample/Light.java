package com.balabasciuc.design_patterns.BehavioralPatterns.CommandPattern.RemoteControlExample;

public class Light {

    private String lightLocation;
    private int lightLevel;

    public Light(String lightLocation) {
        this.lightLocation = lightLocation;
    }

    void on()
    {
        System.out.println("Lighting on");
    }

    void off()
    {
        System.out.println("Lighting off");
    }

    public void diminuateLight(int levelOfLight)
    {
        this.lightLevel = levelOfLight;
        if(lightLevel == 0)
        {
            off();
        }
        else
            System.out.println("Light is diminuated with " + levelOfLight);
    }

    public int getLightLevel() {
        return lightLevel;
    }
}

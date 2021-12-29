package com.balabasciuc.design_patterns.BehavioralPatterns.CommandPattern.RemoteControlExample;

public class LivingRoomLightOnCommand implements Command {

    private Light light;

    public LivingRoomLightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}

package com.balabasciuc.design_patterns.BehavioralPatterns.CommandPattern.RemoteControlExample;

public class TVOnCommand implements Command {

    private TV tv;

    public TVOnCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.on();
        tv.setInputChannel();
    }

    @Override
    public void undo() {
        tv.off();
    }
}

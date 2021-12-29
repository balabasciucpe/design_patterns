package com.balabasciuc.design_patterns.BehavioralPatterns.CommandPattern.RemoteControlExample;

public class NoCommand implements Command {


    @Override
    public void execute() {
        System.out.println("No command...");

    }

    @Override
    public void undo() {

    }
}

package com.balabasciuc.design_patterns.BehavioralPatterns.CommandPattern.RemoteControlExample;

public interface Command {

    //nu intoarcem nimic, doar e o comanda - CQRS, in Q returnam obj, in Command doar trimitem comenzi
    void execute();
    void undo();
}

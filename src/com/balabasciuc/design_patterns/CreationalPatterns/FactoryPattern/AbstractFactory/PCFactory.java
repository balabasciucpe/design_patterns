package com.balabasciuc.design_patterns.CreationalPatterns.FactoryPattern.AbstractFactory;

public class PCFactory implements ComputerAbstractFactory {

    private String ram;
    private String hhd;
    private String cpu;

    public PCFactory(String ram, String hhd, String cpu) {
        this.ram = ram;
        this.hhd = hhd;
        this.cpu = cpu;
    }

    @Override
    public Computer createComputer() {
        return new PC(ram, hhd, cpu);
    }


}

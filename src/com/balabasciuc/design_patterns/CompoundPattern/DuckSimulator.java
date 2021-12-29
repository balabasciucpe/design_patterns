package com.balabasciuc.design_patterns.CompoundPattern;

public class DuckSimulator {

    private AbstractDuckFactory abstractDuckFactory = new CountingDuckFactory();


    public void simulate(AbstractDuckFactory abstractDuckFactory)
    {
        Quackable mallardDuck = abstractDuckFactory.createMallardDuck();
        Quackable redHeadDuck = abstractDuckFactory.createRedHeadDuck();
        Quackable rubberDuck = abstractDuckFactory.createRubberDuck();
        Quackable gooseAdapter = new GooseAdapter(new Goose());


        System.out.println("\n Duck Simulator starting... ");
        simulate(mallardDuck);
        simulate(redHeadDuck);
        simulate(rubberDuck);
        simulate(gooseAdapter);

        System.out.println("Composite ducks at work");
        FlockComposite flockOfDucks = new FlockComposite();
        flockOfDucks.add(mallardDuck);
        flockOfDucks.add(redHeadDuck);
        flockOfDucks.add(rubberDuck);
        flockOfDucks.add(gooseAdapter);

        FlockComposite flocksOfMallards = new FlockComposite();
        Quackable mallardOne = new MallardDuck();
        Quackable mallardTwo = new MallardDuck();
        Quackable mallardThree = new MallardDuck();
        flocksOfMallards.add(mallardOne);
        flocksOfMallards.add(mallardTwo);
        flocksOfMallards.add(mallardThree);

        flockOfDucks.add(flocksOfMallards);
        System.out.println("\nWhole Flock Composite Simulator");
        simulate(flockOfDucks);

        System.out.println("\n Mallard Ducks Composite Simulator");
        simulate(flocksOfMallards);

        Quackologist quackologist = new Quackologist();
        flockOfDucks.registerObservable(quackologist);
        System.out.println("We have " + QuackCounterDecorator.getQuackCounter() + " quacks by now");
    }

    private  void simulate(Quackable quackable)
    {
        quackable.quack();
    }
}

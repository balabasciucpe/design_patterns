package com.balabasciuc.design_patterns;

import com.balabasciuc.design_patterns.BehavioralPatterns.IteratorPattern.DinnerMenu;
import com.balabasciuc.design_patterns.BehavioralPatterns.IteratorPattern.Menu;
import com.balabasciuc.design_patterns.BehavioralPatterns.IteratorPattern.PancakeHouseMenu;
import com.balabasciuc.design_patterns.BehavioralPatterns.IteratorPattern.Waitress;
import com.balabasciuc.design_patterns.BehavioralPatterns.StatePattern.GumballMachine;
import com.balabasciuc.design_patterns.BehavioralPatterns.TemplatePattern.CaffeineBeverage;
import com.balabasciuc.design_patterns.BehavioralPatterns.TemplatePattern.Coffe;
import com.balabasciuc.design_patterns.BehavioralPatterns.TemplatePattern.HookExample.CaffeineBeverageWithHook;
import com.balabasciuc.design_patterns.BehavioralPatterns.TemplatePattern.HookExample.CoffeWithHook;
import com.balabasciuc.design_patterns.BehavioralPatterns.TemplatePattern.HookExample.TeaWithHook;
import com.balabasciuc.design_patterns.BehavioralPatterns.TemplatePattern.Tea;
import com.balabasciuc.design_patterns.CompoundPattern.AbstractDuckFactory;
import com.balabasciuc.design_patterns.CompoundPattern.CountingDuckFactory;
import com.balabasciuc.design_patterns.CompoundPattern.DuckSimulator;
import com.balabasciuc.design_patterns.CreationalPatterns.FactoryPattern.AbstractFactory.*;
import com.balabasciuc.design_patterns.CreationalPatterns.FactoryPattern.AbstractFactory.animalExample.AbstractFactory;
import com.balabasciuc.design_patterns.CreationalPatterns.FactoryPattern.AbstractFactory.animalExample.FactoryProvider;
import com.balabasciuc.design_patterns.CreationalPatterns.FactoryPattern.MethodFactory.Autobuz;
import com.balabasciuc.design_patterns.CreationalPatterns.FactoryPattern.MethodFactory.BucurestiAutobuzForTheSakeOfExample;
import com.balabasciuc.design_patterns.StructuralPatterns.AdapterPattern.*;
import com.balabasciuc.design_patterns.StructuralPatterns.AdapterPattern.iteratorExample.IteratorEnumerationAdapter;
import com.balabasciuc.design_patterns.BehavioralPatterns.CommandPattern.RemoteControlExample.Light;
import com.balabasciuc.design_patterns.BehavioralPatterns.CommandPattern.RemoteControlExample.LightOffCommand;
import com.balabasciuc.design_patterns.BehavioralPatterns.CommandPattern.RemoteControlExample.LightOnCommand;
import com.balabasciuc.design_patterns.BehavioralPatterns.CommandPattern.RemoteControlExample.RemoteController;
import com.balabasciuc.design_patterns.BehavioralPatterns.CommandPattern.orderExample.Broker;
import com.balabasciuc.design_patterns.BehavioralPatterns.CommandPattern.orderExample.BuyStock;
import com.balabasciuc.design_patterns.BehavioralPatterns.CommandPattern.orderExample.SellStock;
import com.balabasciuc.design_patterns.BehavioralPatterns.CommandPattern.orderExample.Stock;
import com.balabasciuc.design_patterns.StructuralPatterns.DecoratorPattern.Beverage;
import com.balabasciuc.design_patterns.StructuralPatterns.DecoratorPattern.Espresso;
import com.balabasciuc.design_patterns.StructuralPatterns.DecoratorPattern.Mocha;
import com.balabasciuc.design_patterns.BehavioralPatterns.ObserverPattern.CurrentConditionsDisplay;
import com.balabasciuc.design_patterns.BehavioralPatterns.ObserverPattern.WeatherData;
import com.balabasciuc.design_patterns.BehavioralPatterns.ObserverPattern.newsExample.NewsAgency;
import com.balabasciuc.design_patterns.BehavioralPatterns.ObserverPattern.newsExample.NewsChannel;
import com.balabasciuc.design_patterns.BehavioralPatterns.StrategyPattern.Duck;
import com.balabasciuc.design_patterns.BehavioralPatterns.StrategyPattern.DuckMallard;
import com.balabasciuc.design_patterns.BehavioralPatterns.StrategyPattern.DuckRubber;
import com.balabasciuc.design_patterns.BehavioralPatterns.StrategyPattern.FlyingInTheWeather;
import com.balabasciuc.design_patterns.BehavioralPatterns.StrategyPattern.discountExample.Discounter;
import com.balabasciuc.design_patterns.BehavioralPatterns.StrategyPattern.discountExample.EasternDiscounter;
import com.balabasciuc.design_patterns.BehavioralPatterns.StrategyPattern.studentExample.InvatDupamasa;
import com.balabasciuc.design_patterns.BehavioralPatterns.StrategyPattern.studentExample.Student;
import com.balabasciuc.design_patterns.BehavioralPatterns.StrategyPattern.studentExample.StudentConstiincios;
import com.balabasciuc.design_patterns.StructuralPatterns.FacadePattern.ShapeMaker;
import com.balabasciuc.design_patterns.StructuralPatterns.ProxyPattern.ProtectionProxy.ProxyPerson;
import com.balabasciuc.design_patterns.StructuralPatterns.ProxyPattern.RemoteProxy.Client.ClientRMI;
import com.balabasciuc.design_patterns.StructuralPatterns.ProxyPattern.RemoteProxy.Server.ServerRMI;
import com.balabasciuc.design_patterns.StructuralPatterns.ProxyPattern.VirtualProxy.Company;
import com.balabasciuc.design_patterns.StructuralPatterns.ProxyPattern.VirtualProxy.ContactList;
import com.balabasciuc.design_patterns.StructuralPatterns.ProxyPattern.VirtualProxy.ContactListProxyImpl;
import com.balabasciuc.design_patterns.StructuralPatterns.ProxyPattern.VirtualProxy.Employee;

import java.math.BigDecimal;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here

        //StrategyPattern
        System.out.println("\n ---------- Strategy Pattern -----------");
        Duck duckMallard = new DuckMallard();
        duckMallard.performFly();
        duckMallard.quackBehaviour();

        System.out.println();
        Duck rubberDuck = new DuckRubber();
        rubberDuck.setFlyBehaviour(new FlyingInTheWeather());
        rubberDuck.performFly();

        System.out.println();
        Student student1 = new StudentConstiincios();
        student1.invat();
        student1.setModDeInvatare(new InvatDupamasa());
        student1.invat();

        System.out.println();
        Discounter easternDiscounter = new EasternDiscounter();
        BigDecimal discountedValue = easternDiscounter.applyDiscount(BigDecimal.valueOf(100));
        System.out.println("Discounted value for Eastern is: " + discountedValue);


        System.out.println("\n ---------- Observer Pattern -----------");
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        weatherData.setMeasurements(30.0f, 20.0f, 10.0f);

        NewsAgency newsAgency = new NewsAgency();
        NewsChannel newsChannel = new NewsChannel(newsAgency);
        newsAgency.setBreakingNews("Example");


        System.out.println();
        System.out.println("\n ---------- Decorator Pattern ---------------");
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " " + beverage.cost());


        beverage = new Mocha(beverage);
        System.out.println(beverage.getDescription() + " " + beverage.cost());

        Beverage beverage2 = new Mocha(beverage);
        System.out.println(beverage2.getDescription() + " " + beverage2.cost());

        System.out.println("\n\n------- Factory Method Pattern --------");
        Autobuz autobuz = new BucurestiAutobuzForTheSakeOfExample();
        autobuz.emitereBilet("aeroport");

        System.out.println("\n -----Abstract Factory Pattern------");
        Computer pc = ComputerFactory.getComputer(new PCFactory("a", "b", "c"));
        System.out.println("pc is " + pc);

        System.out.println("\nAnimal example");
        AbstractFactory factoryProvider = FactoryProvider.getFactory("animal");
        factoryProvider.createType("dog");
        factoryProvider.createType("bear");


        System.out.println("\n-------- Adapter Pattern ----------");
        //AdapterPattern
        com.balabasciuc.design_patterns.StructuralPatterns.AdapterPattern.Duck duck = new MallardDuck();
        Turkey turkey = new WildTurkey();
        com.balabasciuc.design_patterns.StructuralPatterns.AdapterPattern.Duck turkeyAdapter = new TurkeyAdapter(turkey);
        System.out.println("Turkey says..");
        turkey.glugluglu();
        turkey.fly();
        System.out.println("Duck says...");
        duck.fly();
        duck.quack();
        System.out.println("TurkeyAdapter says...");
        turkeyAdapter.quack();
        turkeyAdapter.fly();
        //continuam...
        System.out.println("DuckAdapter");
        com.balabasciuc.design_patterns.StructuralPatterns.AdapterPattern.Duck duckAdapter = new MallardDuck();
        Turkey duckAdapterForTurkey = new DuckAdapter(duckAdapter);
        duckAdapterForTurkey.fly();
        duckAdapterForTurkey.glugluglu();

        //continuamCuAltExemplu

        System.out.println("\n-----Adapter Pattern: Iterator Example: --------------");
        List<String> stringList = new ArrayList<>(List.of("a", "B", "c"));
        Enumeration<?> enumeration = new IteratorEnumerationAdapter(stringList.iterator());
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }


        System.out.println("\n------Command Pattern---------");
        RemoteController remoteController = new RemoteController();
        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight = new Light("Kitchen Light");

        LightOnCommand livingRoomLightOnCommand = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOffCommand = new LightOffCommand(livingRoomLight);

        LightOnCommand kitchenRoomLightOnCommand = new LightOnCommand(kitchenLight);
        LightOffCommand kitchenRoomLightOffCommand = new LightOffCommand(kitchenLight);

        remoteController.setCommand(0, livingRoomLightOnCommand, livingRoomLightOffCommand);
        remoteController.setCommand(1, kitchenRoomLightOnCommand, kitchenRoomLightOffCommand);
        System.out.println(remoteController); //prints toString method

        remoteController.onButtonWasPushed(1);
        remoteController.offButtonWasPushed(2);
        remoteController.onButtonWasPushed(3);

        System.out.println("Order Example");
        Broker broker = new Broker();
        Stock stock = new Stock();
        BuyStock buyStock = new BuyStock(stock);
        SellStock sellStock = new SellStock(stock);

        broker.takeOrder(buyStock);
        broker.takeOrder(sellStock);
        broker.placedOrders();

        System.out.println("\n -------Facade Pattern-------");
        ShapeMaker shapeMaker = new ShapeMaker();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();

        System.out.println("\n -------Template Pattern-------");
        Tea tea = new Tea();
        tea.prepareRecipe();
        System.out.println();
        CaffeineBeverage coffe = new Coffe();
        coffe.prepareRecipe();

        System.out.println("\n Hook Example");
        CaffeineBeverageWithHook coffeWithHook = new CoffeWithHook();
        coffeWithHook.prepareRecipe();
        System.out.println();
        TeaWithHook teaWithHook = new TeaWithHook();
        teaWithHook.prepareRecipe();

        System.out.println("\n --------Iterator Pattern--------");
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        Menu menu = new DinnerMenu();
        List<Menu> menus = new ArrayList<>();
        menus.add(pancakeHouseMenu);
        menus.add(menu);
        Waitress waitress = new Waitress((ArrayList<Menu>) menus);
        waitress.printMenu();
        waitress.printVegetarianMenu();

        System.out.println("\n -------State Pattern--------");
        GumballMachine gumballMachine = new GumballMachine(2);
        System.out.println(gumballMachine);

        gumballMachine.insertQuarter();
        System.out.println(gumballMachine);
        gumballMachine.turnCrank();
        System.out.println(gumballMachine);

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        System.out.println(gumballMachine); // soldOutState

        gumballMachine.refillNumberOfGumblles(2);
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        System.out.println(gumballMachine); //NoQuarterState


        System.out.println("\n ------------Different Patterns at work----------");
        DuckSimulator duckSimulator = new DuckSimulator();
        AbstractDuckFactory abstractDuckFactory = new CountingDuckFactory();
        duckSimulator.simulate(abstractDuckFactory);


        System.out.println("\n ------ProxyPattern-------");

        System.out.println("\n --------Virtual Proxy---------");
        ContactList contactList = new ContactListProxyImpl();
        Company company = new Company("Microsoft", "USA", contactList);
        System.out.println("Company Name is " + company.getCompanyName());
        System.out.println("Requesting for Contact List");
        contactList = company.getContactList();
        List<Employee> employeeList = contactList.getEmployeeList();
        for (Employee emp : employeeList) {
            System.out.println("Employee is " + emp);
        }

        System.out.println("\n -----------Security Proxy to see...");
        ProxyPerson proxyPerson = new ProxyPerson();
        proxyPerson.drive();


        System.out.println("\nProxy RMI");
        ServerRMI.startServer();
        ClientRMI.startClient();

        goodByeMessage();
    }

    static void goodByeMessage()
    {
        System.out.println("\n   Sper ca v-a placut cat de cat acest tur prin Design Patterns... MAI URMEAZA");
    }
}

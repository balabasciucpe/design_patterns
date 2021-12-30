# design_patterns - different notes to understand the concepts behind Design Patterns...



Creational Patterns for the creation of objects; Structural Patterns to provide relationship between objects; and finally, Behavioral Patterns to help define how objects interact.


Strategy Pattern
- Essentially, the strategy pattern allows us to change the behavior of an algorithm at runtime.
prefer composition> inheritance
program to superType...interfaces

Supertype a = new SubType();
a.metodeDinSubType;

a clien/app uses algorithms interchangbly, that means we decouple clients from algorithms, and in runtime, a strategy is chosen, deci algoritmii sunt interfete, iar clasele concrete/ algos pot fi schimbati fara sa afecteze clientul


deci izolam comportamentul ce variaza de la clasa la clasa, si il lasam doar pe cel care nu variaza
adica wildduck, city duck extends Duck si metoda fly din Duck, dar rubberDuck can t fly - deci cum sa extinda metoda fly din Duck?
-acesta este un comportament ce variaza de la clasa la clasa, il izolam, il scoatem afara 
- clasa MountainDuck are tot metoda fly, dar variaza, nu e aceeasi ca la celelalte - variaza

obtinem flexibilitate prin interfete deoarece interfata poate deveni orice clasa concreta, in schimb clasa concreta e cimentata - abstractizare
deci algoritmul, comportamentul ce variaza: FlyBehaviour, QuackBehaviour sunt interfete si scoase afara din clasa/interfata de unde variaza
-daar avem compozitie, o referinta de tip FlyBehaviour in Duck, Interfata avand metoda fly() si fiind implementata de clase concrete in functie de behaviour, strategy diferite
iar in clasele ce extind clasa de baza/interfata, putem seta in runtime comportamentul ce variaza, instantiind o clasa concreta ce implementeaza strategia

clasele concrete ce impl interfata - sunt diferite strategii/behaviours ce sunt folosite in functie de clasele ce extind clasa de baza

in runtime, clasa ce extinde clasaAbstracta si are o referinta catre InterfataBehaviour, poate lua in runtime orice strategie/comportament, in functie de clasa ei, adica ce ii trebe e

COMPOSITIE > INHERITANCE

putem avea comportamente/algoritmi abstracti in clasa abstracta ce e extinsa de alta, iar in runtime sa avem comportamente diferite - FAIN 
spec mereu change, deci chiar daca avem la o clasa un comportament diferit, in viitor o sa fie 100 de clase, deci facem strategy pattern 

!!
facem toate astea prin DI, prin constructorul clasei abstracte, ori constructorul claselor ce implementeaza clasa abstracta
putem pune si setters in clasa abstracta ce seteaza algoritmii ca sa-i schimbam in runtime - dinamic nu static

in algoritmi-interfete avem metodele specifice lor flyBehaviour - fly() method, iar in concrete impl vom face metoda aia
in clasa abstracta vom invoca metodele din interfetele/strategy prin metodele: performFly() { this.flyBehaviourInterface.fly();}

Key Point:
Strategy patterns defines a family of algorithms(clasele concrete ce impl interfata), incapsuleaza algoritmul din ei(metoda din interfata care e extinsa si care e lucrata in concreteImpl) and make them interchangeble(pt. ca algoritmii sunt de tip Interfata: QuackLouder, NoQuack sunt de tip QuackBehaviour, algoritmii, sunt de tip strategy
prin interchangeble putem folosi oricare dintre concrete algoritms
fiecare algoritm poate varia cat de mult vrea de celalalt algoritm, fara sa schimbam deloc codul in client, deoarece e doar o interfata acolo


o metoda abstracta in supertype iar in subtype va fi folosite in mod diferit in functie de subtype
deci comportamentul ce variaza il izolam si il scoatem afara, ne dam seama de acest comportament daca clasele ce extind/impl supertype ul au rezultate si cerinte diferite

composition for mentenance

mostenirea ne da urm probleme: 
-code duplicated along classes ce extind supertype-ul
- runtime behaviour changes are difficult
- changes pot afecta neintentionat alte clase ce impl acel comportament variant

Design Principle: Identifica aspectele our app that  changes over time and isolate them from what stays the same take the parts that vary and encapsulate them, so that later you can alter or extend the parts that vary without affecting those that don’t.
take the parts that vary and encapsulate them, so that later you can alter or extend the parts that vary without affecting those that don’t

Design Principle: Program to an interface not an implementation

Design Principle: Favor Composition over inheritance

Design Principle: make the best to construct loose coupled obj - 

setters in the Duck for the behaviour - that s way we can change the Behaviour of a specific concrete Impl of our Duck class in runtime
eram blocati in Duck classes de implementare, si nu-l puteam schimba in runtime, asa o putem face, deoarece folosim interfete si mai apoi folosim concrete impl of that interfaces, not concrete at the beggining

Program to a superType =  Interfata/AbstractClass var = new SubType();
even better: SuperType superType = new SuperType(); 
superType.makeAnimals()... //assign the concrete impl at runtime
void makeAnimals() { aici assign the concrete impl at runtime SuperType dog = new Dog(); }
----nu stim ce SubType e, stim doar ca stie sa rasp la metoda makeAnimals();  === FRUMOS
--aici e exemplul de aici: https://stackoverflow.com/questions/68341700/java-assign-the-concrete-implementation-object-at-runtime - usor de inteles -> apelam o metoda care ne intoarce un obj de subtype of our supertype, nu il hardcoding instantiem


Exemplu:
abstract class Duck { FlyBehaviour flyBehaviour; public void fly() { flyBehaviour.fly(); }

Reuse in the Strategy pattern -> alte clase sau obj pot folosi our behaviour/strategy pt. ca nu mai sunt ascunse in clasa noastra abstracta
--> si putem modifica sau adauga alte comportamente/algoritmi fara sa schimbam ceva in clasele concrete, sau in clasele ce folosesc acesti algoritmi


Integrating StrategyPattern:
-a duck will delegate his algorithms/behaviours instead of using his algorithms in his own classes or subclases
how:
-declare a interface type
-declare methods for use interfaceType.method -> performQuack() { QuackBehaviour.quack() }

--aici programam to a concrete impl, in constructor, ceea ce nu e oki...
-setam comportamentul/variabilele ori prin subclase in constructor -> class cityDuck extends Duck -> { constructor { flyBehaviour = new FlyWithWings(); } ori in runtime, furnizam setters in clasa abstracta, iar in subclasa apelam setters si furnizam implementarea atunci
-> asa ca mai bine nu o facem in constructor, ci prin setters clasei abstracte - in runtime

mostenirea ne permine reuse of code but with the cost of flexibility and maintenance
design patterns ne ajuta sa urmam principiile oo dar si sa construim sisteme flexibile reusable and maintenable - doar folosind oo nu merge


Alte nume pt. acelasi DesignPattern: Policy
when to use:
- clasele difera doar intr-un comportament... ducks classes
- a class define multiple behaviours.... nu e ok pt. ca avem if stataments if(duckIsWildDuck( { flyBehaviour.....

Participanti: StrategyInterface, ConcreteStrategies who implement the IStrategy, Context which have a reference to an StrategyInterface obj through composition  
colaboration in this design: sunt clasele intre ele, cum comunica: clientul se foloseste de context, iar  contextul trimite cererea prin Interfata to concreteImplStrategies

avantaje: family of algorithm, maintenance because composition, alternative to subclasing - evitand code reuse among classes where is not need to


With this design, other types of objects can reuse our fly and quack behaviors because these behaviors are no longer hidden away min our Duck classes!
And we can add new behaviors without modifying any of our existing behavior classes or touching any of the Duck classes that use flying behaviors.
=== code reuse with composition not inheritance

-a duck will delegate the algoritms behaviour instead of using them in our duck class

When you put two classes together like this you’re using composition. Instead of inheriting their behavior, the ducks get their behavior by being composed with the right behavior object.
Not only does it let you encapsulate a family of algorithms into their own set of classes, but it also lets you change behavior at runtime as long as the object you’re composing with implements the correct behavior interface.

We could have used composition to create instance variable for strategies but we should avoid that as we want the specific strategy to be applied for a particular task
- adica cand folosim in Concrete\Context metoda ce necesita o strategie, o folosim parametrul cu ConcreteStrategy - a alternative way of doing things
 


GOF Motivare:
- clientii/contextul devine mai complex daca includem algoritmii concreti
- Clientii nu folosesc acelasi algoritm sau il folosesc cand au nevoie - il punem degeaba uneori - code duplication along classes
- extensibilitate si flexibilitate problem -> daca vrem sa adaugam alti algoritmi la cei deja existenti avem sansa sa break code

GOF When to use:
- cand clasele concrete de baza difera doar intr-un algoritm/behaviour de a face ceva - duck for QuackBehaviour
- cand avem nevoie de anumite variante ale acestui algoritm: space/time sau time periods, discounts 
- dorim ascunderea datelor de catre client -> incapsulare
- in loc de if else, switch folosim Strategy algoritms
- when the variation of the behaviour/strategy is relevant to clients/contexts

GOF Consequences:
-  Encapsulating the algorithm in separate Strategy classes lets you vary the algorithm independently of its context, making it easier to switch, understand, and extend
- eliminate if statements: if thatContextIsLikeThis then AlgoritmA else if
- numar crescut de obj din cauza dif concreteBehaviours -> FlyWeight Pattern pt asta
- uneori anumiti parametri din Context nu sunt folositi de ConcreteStrategies
- pagina 339 din GOF, parametri intre Context si Strategy
- putem avea a defaultStrategy care merge pt. toate care nu necesita ceva anume



-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


Observer Pattern
an area of change, ceva ce se schimba -> incapsulare prin metoda, ceva ce se schimba in functie de parametri

observable-ul primeste date pe care le trimite observatorilor prin notificari, observatorii pot fi observable la randul lor pt. alti observatori

Observer Pattern
- defineste o relatie one to many unde un observabil trimite notificari catre ceilalti observatori atunci cand datele i se schimba si datele componentelor dependente sunt updatate automat
when the obj change their state it s notify the observers
putin asemanator cu Publish Subscribe Pattern

pagina 80 - guidance thru the code

area of changes = diff methods, concrete classes, behaviours


2 obj loose couple = can interact but knows a little about each other, asta ne face un sistem flexibil, pt. ca putem sa-l schimbam fara sa fim dependenti de celalalt obj
Loosely coupled designs allow us to build flexible OO systems that can handle change because they minimize the interdependency between objects.
- pagina 92 ne arata cum, dar in principiu prin abstractizare si incapsulare 



ce am facut pana acum in cod in intellij e cu push, adica obervabilul push changes to observers everytime something has changed but we dont really need all of those values, so instead we let observers to pull for values which they need
-pagina 107 arata cum facem schimbarea de la push la pull iar pagina 97 ne arata un exemplu de push
one to many relationship, o schimbare intr-un observabil transmite datele schimbate catre mai multi observatori
pull > push -adica observabilul are getter methods, pe care concreteObs il ia 
=depinde de observator ce alegem pull/push, uneori vrem toate datele, alteori vrem unele date etc


in constructor fara parametru intializam listele... cand construim obj, sa intializam si lista, chiar daca elemente 0 

avem nevoie in our concrete Observer de un concret obserrvable, ca sa putem adauga ca observatori ai observabilului -> adica concreteObserverClass... { concreteObservableClass obj... obj.addObserver(this) - vezi intellij

encapsule every area of change...
By coding to concrete implementations, we have no way nto add or remove other display elements without making changes to the code
-deci interfata.metoda ... si o sa fie notificate si clasele ce impl interfata si implicit metoda

public void update() {
this.temperature = weatherData.getTemperature();
this.humidity = weatherData.getHumidity();
display();


Why to use ObserverPattern:
A common side-effect of partitioning a system into a collection of cooperating classes is the need to maintain consistency between related objects. You don't want to achieve consistency by making the classes tightly coupled, because that reduces their reusability.
Subject == Observable in our case

When to use:
- cand schimbarea datelor asupra unui obj determina schimbarea altor date in alte obj, bazandu-ne pe datele schimbate ale primului obj 
- reducem loose coupling between obj, folosindu-ne de abstractizare + trebe ca un obj sa notifice alte obj, dar nu vrem sa stim ce obj concrete  sunt
- cand o abstractizare are 2 parti, una dependenta de cealalta, incapsuland aceste parti le putem schimba, varia, extinde with advantages of loose coupling

ConcreteSubject - changesData > SubjectInterface -> ObserverInterface - pullData > ConcreteObservator




At one extreme, which we call the push model, the subject sends observers detailed information about the change, whether they want it or not. 
At the other extreme is the pull model; the subject sends nothing but the most minimal notification,and observers ask for details explicitlythereafter.
The pull model emphasizes the subject'signorance of its observers, whereas the push model assumes subjects know something about their observers' needs.
 The push model might make observers less reusable, because Subject classes make assumptions about Observer classes that might not always be true.
 On the other hand, the pull model may be inefficient, because Observer classes must ascertain what changed without help from the Subject.


putem adauga observatori fara sa modificam subiectul sau alti observatori, putem refolosi obs sau sub sau ambii
abstract coupling between subject and observator - loose couplig through interfaces
putem adauga obs sau remove at any time deoarece subj doar trimite notificarea, nu stie cui sau cator

de recitit la final - rezumat
pagina 317 GOF - sa recitest


------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Decorating Pattern


decorate your classes at runtime using a form of object composition. Why?
 Once you know the techniques of decorating, you’ll be able to give your (or someone else’s) objects new responsibilities without making any code changes to the underlying classes


compile time inseamna ca trebe sa schimbam codul si sa-l compilam, runtime inseamna ca se face schimbarea cand ruleaza programu, fara sa schimbam nica

metodele abstracte intr-o clase trebe implementate separat de fiecare clasa 

spec changes in the future!
Our goal is to allow classes to be easily extended to incorporate new behavior without modifying existing code.\ 
What do we get if we accomplish this? Designs that are resilient to change and flexible enough to take on new functionality to meet changing requirements


Reusing with Inheritance and Composition:
cand folosim mostenirea, subclasele trebe sa mosteneasca metodele superclaselor, iar behaviorul acestora este setat static, in compile time - in plus, unele subclase nu ar trebui sa aiba metode, comportament mostenit din supraclasa, in timp ce altele ar trebui - vezi strategy pattern
in schimb, cand folosim compozitie, putem seta dinamic acest behaviour, in runtime polymorfism

Remember, code should be closed (to change) like the lotus flower in the evening, yet open (to extension) like the lotus flower in the morning
-adica cream noi behaviour, responsabilitati, clase in runtime si le atribuim codului curent, fara sa schimbam codul curent, prin compositie

Design Principle:
Closed Open Principle: clasele ar trebui sa fie open/deschise pentru extensie dar closed/inchise pt. a fi modificate, astfel stiind ca nu bagam bug-uri daca alteram codul

!!!!!!!!!!!!!!!!StarBuzz example
acesti design il folosim cand avem o clasa de baza si o multime de functionalitati diferite - clase explosion sau schimbam doar cateva clase, dar care trebe sa testeze tot,  - iarasi gresit

Decorator Pattern adauga un set de functionalitati/responsabilitati in mod dinamic unei clase, fara a fi nevoie de a modifica codul existent
prin acest fel evitam mostenirea si compile time polimorfism asigurandu-ne flexibilitate

decoratorii adauga behaviour to obj that wrap

folosim clase abstracte deoarece putem pune o default implementation of a specific method on one abstract class, where other class subclassiing that abstract class can use, in interface we cannot provide a default impl of a method
abstract classes define a set of default basics for a set of classes, un fel de sablon

Interface Segregation Principle: clasele nu trebuie sa depinda sau sa implementeze metodele de care nu are nevoie - pe care nu le foloseste, fie ca vorbim de supertype sau nu
deci spune ca ar trebui sa avem mai multe interfete mai mici cu metode impartite pe care clase diferite sa implementeze/foloseasca ce au nevoie decat o interfata monolit implementata cu metode pe jumatate ce nu sunt nevoie


folosim Decorator cand vrem sa profitam de clasa deja existenta, fara sa o schimbam sa-i schimbam codul, ci doar sa-i adaugam noi functionalitati


OPC - una dintre tehnici pt. a construi un astfel de sistem e Observator Pattern, alta e DecoratorPattern, in Observator doar schimbam observatorii iar observabilul ramane la fel, in Decorator, decoram in jurul componentei

Motive de a folosi Decorator: cand adaugam class explosion sau cealalta varianta e cand unele proprietati in clasa mare nu sunt potrivite pt. subclase - deci nu prea merge mostenirea pt. a crea sisteme flexibile si extensibile decat in mica masura
-mai avem ca putem adauga functionalitate unei clase  fara sa folosim mostenirea / subclasarea

delegarea metodelor se face din decoratorul extern catre decoratorii interni catre obj principal, iar obj principal va intoarce un rezultat la care se adauga rezultatul decoratorului intern la care se adauga rezultatele decoratorilor ramasi

Decoratorii:
-au acelasi supertype ca si obiecttul pe care-l decoreaza -> obiectul decorat extinde clasa Masina, Decoratorul e de tip Masina tho, deci va avea acelasi metode si instance variabile, poate adauga chiar si alte noi metode = flexibilitate
- putem folosi unul sau mai multi decoratori to wrap an obj\
- decoratoru adauga propria functionalitate/metoda inainte si/sau dupa deleaga obiectului pe care-l decoreaza sa faca restul job-ului
- obiectele pot fi decorate oricand, o putem face dinamic in runtime oricand

Condimentul/Decoratorul adica extinde si clasa ComponenteiContrete -> Adica clasa abstract Componenta
-> prin urmare folosim mostenire aici, dar doar pt. type matching, deoarece Decoratorul trebe sa fie de acelasi type cu ComponentaConcreta pe care-o decoreaza
--> deci Decoratorul va avea o instanta variabila a clasei Component abstract, dar o va si extinde, instanta va fi de fapt obj pe care-l va decora, obj ce va deveni o clasa concreta
----> nu folosim mostenire to get behaviour
------> when we compose a decorator with an component, we adding new functionality to that component, prin compozitie facem asta nu prin mostenire, compozitie compozand obj impreuna
------->Okay, so we’re subclassing the abstract class Beverage in order to have the correct type, not to inherit its behavior. The behavior comes in through the composition of decorators with the base components as well as other decorators


The Decorator Pattern attaches additional responsibilities to an object dynamically. Decorators provide a flexible alternative to subclassing for extending functionality


cand folosim decoratori - trebe nu doar sa instantiem obj concret, dar si sa o invelim cu cine stie cati decoratori

daca o clasa abstracta impl o interfata, nu e obligata sa i impl metodele interfetei, interesant

Decorator also knows as Wrapper
-vrem sa adaugam responsabilitati noi unui obj, nu unei clase -> o putem face prin subclasare dar devenim inflexibili = statici
- vrem sa adaugam responsabilitati si sa le scoatem la un moment dat, daca dorim
- avoid class explosion

Decorator forwards requests to its Component object. It may optionally perform additional operations before and after forwarding the request.



This pattern creates a decorator class which wraps the original class and provides additional functionality keeping class methods signature intact.
Sometimes we want to add responsibilities to individual objects, not to an entire class. - adica un obj va fi decorat cu altceva, alt obj al clasei respective va fi decorat cu altcv


using delegation, in decoratorConcreteClasses apelam componentConcrete.method + decoratorConcreteMethod - adaugam functionalitati diferite la cv existent, inainte sau dupa
 Beverage beverage2 = new DarkRoast(); //concrete component
 beverage2 = new Mocha(beverage2);
  ConcreteDecorator ia un obj de tipBeverage *concreteComponent aici, si impl Beverage for typeMaching
- iar aici concreteComponent ia noi responsabilitati, e extins de catre Decoratori
- before or after -> adaugam functionalitate inainte sa apelam functionalitatea ConcreteComponent prin it s superType or after

Avantaje: putem adauga si retrage functionalitati in runtime, fara sa folosim mostenirea statica
- putem adauga rresponsabilitatile pe care le dorim, nu ca in strategy cand unele subclase are behaviour strain clasei
issues: - daca avem nevoie doar de un decorator, putem skip abstract class Decorator si folosim concreteDecorator class

Strategy > Decorator cand Component e o clasa complexa, poate sa aiba propria interfata cand in Decorator trebe sa aiba acelasi superType ca si Componenta
.In the Strategypattern, the component forwards some ofits behavior to a separate strategy object. The Strategy pattern lets us alter or extend the component's functionality by replacing the strategy object.
decoratorul change the Component from the outside,  sunt transparenti pt. componente
in strategy - componenta stie despre posibile extensii ale comportamentului Componentei

in ConcretDecorator putem apela in methode cu super.Methoda din clasa Componenta decorata before/after our decoration, putem apela in ConstructorulDecorator super(AbstractComponent obj)
putem instantia ConcreteComponent class direct cu decoratorul, sau Decoratorul decoreaza ConcreteComponent =>
Car sportsCar = new SportsCar(new BasicCar());
Beverage beverage2 = new Mocha(beverage);




-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Factory Pattern
also Known as Virtual Constructor

Use the Factory Method pattern when
• a class can't anticipate the class of objects it must create.- depinzand de parametru
• a class wants its subclasses to specify the objectsit creates. - decoupling client from producer
• classes delegate responsibility to one of several helper subclasses, and you vwant to localize the knowledge of which helper subclass is the delegate.

polymorfism at runtime - daca avem o factory care wraps an obj, we can instantiate that var factory, and in runtime we can swap that factory for the obj - polimorfism\
Pizza pizza = new Pizza(); si flexibilitate, aici folosim PizzaFactory.createPizza(inFunctieDeParametri) - poate lua orice subclasa in functie de parametri

clasa ce extinde este de acelasi tip daca se folosesste extinderea

"Create objects in a separate operation so that subclasses can override the way they're created." This rule ensures that designers of subclasses can change the class of objects their parent class instantiates if necessary.




 If your code is written to an interface, then it will work with any new classes implementing that interface through polymorphism. 
However, when you have code that makes use of lots of concrete classes, you’re looking for trouble because that code may have to be changed as new concrete classes are added. 
So, in other words, your code will not be “closed for modification.” To extend your code with new concrete types, you’ll have to reopen it - if stataments... if() then new classA...classB


What vary here? Object creation - depinzand de parametri - incapsuleaza intr-o Factory cu o methodStatic with that abstractClass.methodFactory



 I’ve seen a similar design where a factory like this isv defined as a static method. What’s the difference?
A: Defining a simple factory as a static method is a commonb technique and is often called a static factory. 
Why use a static method? Because you don’t need to instantiate an object to make buse of the create method. But it also has the disadvantage that you bcan’t subclass and change the behavior of the create method.

while all subclasses make use of the orderPizza() method defined in Pizza Store. We could make the orderPizza() method final if we really wanted to enforce this.

Now, to take this a little further, the orderPizza() method does a lot of things with a Pizza object (like prepare, bake, cut, box), but because Pizza is abstract, orderPizza() has no idea what real concrete classes are involved.
 In other words, it’s decoupled  - adica clientul foloseste o abstractizare, o metoda abstracta, sau un product abstract, iar clasele concrete sunt create de catre factoryClasses, nu de client, el nu stie, decuplat

COPrinciple - code closed to modification
think what vary

pasul 1: incapsuleaza object creation
Simple FactoryPattern - adica un fel de static factory pattern method, dar e clasa in loc de method, allow subclassing and changing of the algoritm and so on

we’ve gone from having an object handle the instantiation of our concrete classes to a set of subclasses that are now taking on that responsibility.
All the responsibility for instantiating Pizzas has been moved into a method that acts as a factory - for instantiating obj in general, intr-o clasa abstracta, o metoda abstracta impl in mod diferit among classes defineste ce obiecte sa instantiem 
A factory method handles object creation and encapsulates it in a subclass. This decouples the client code in the superclass from the object creation code in the subclass.

Def:
The Factory Method Pattern defines an interface for creating an object, but lets subclasses decide which class to instantiate. Factory Method lets a class defer instantiation to subclasses
Because the Creator class is written without knowledge of the actual products that will be created, we say “decide” not because the pattern allows subclasses themselves to decide, but rather, because the decision actually comes down to which subclass is used to create the product
- ConcreteCreator is responsible for creating one or more concrete products. It is the only class that has the knowledge of how to create these products.

abstractizari nu interfete aici
Creator is a class that contains the implementations for all of the methods to manipulate products, except for the factory method - adica putem avea metode care manipuleaza produsele pizza.cut, pizza.box dar nu method factory-ul
When you have code that instantiates concrete classes, this is an area of frequent change - incapsulare
 By placing all my creation code in one object or method, I avoid duplication in my code and provide one place to perform maintenance. That also means clients depend only upon interfaces rather than the concrete classes required to instantiate objects


Dif between SimpleFactory and MethodFactory:
concrete stores are extending a class that has defined createPizza() as an abstract method.
 It is up to each store to define the behavior of the createPizza() method. In Simple Factory, the factory is another object that is composed with the PizzaStore.




Dependency Inversion Principle: 
Depend upon abstractions. Do not depend upon concrete classes. 
-nu instantiem clase concrete in clasa noastra, in schimb delegam asta catre o factory method - 
high-level components should not depend on our low-level components; rather, they should both depend on abstractions
- A “high-level” component is a class with behavior defined in terms of other “low-level” components - dar foloseste abstractizari si nu concrete
MiddleMan between high level and low level components
you don’t want your pizza store to know about the concrete pizza types, because then it’ll be dependent on all those concrete classes!
-> asa ca vrem sa folosim o abstractizare pe care sa o foloseasca atat highLevelu cat si lowLevelul
--> luam design-ul in care highLevelul depinde si e dependent de concret INVERSANDU-L si facandu-l sa fie dependente de abstractizare
----> PizzaStore = highLevel component, are in clasa low level components ca PizzaImplClasses != ok -> suntem dependenti de concrete classes != ok --> trebe sa fim dependenti de abstractizari, ambele componente

How to make use of DependencyInversionPrinciple:
? -  No variable should hold a reference to a concrete class.
 = deci nu folosim new  ca sa instantiem o clasa, ci folosim factory pt. asta
? -  No class should derive from a concrete class. - deoarece depinden de o clasa concreta, dar vrem sa depindem de o abstractizare... deci derive from abstraction
 -  No method should override an implemented method of any of its base classes = inseamna ca nu e oabstractizare pana la urma...
---de retinut
daca clasa e unlike to change, putem sa o instantiem concret, like String, dar daca nu, use the factory!


dependency injection cand stim ce obj o sa instantiem... dar daca nu, si averm parametri, sau business logic ca sa vedem ce sa instantiem, in functie de ce, folosim factory




deci intr-o metoda care are nevoie de obj in functie de ceva, punem logica crearii acelor obj intr-o clasa-fabrica si o metoda a ei - incapsulare ce variaza



PAGINA 160 - EXplicatie - facand metoda abstracta, si supertypeul la fel, am delegat crearea obj catre subclase, noi doar spunem ce supertype return primeste method factory iar subclasele decid ce clasa sa fie instantiate depinzand ce dorim
we’ve gone from having a object handle the instantiation of our concrete classes to a set of subclasses that are now taking on that responsibility.
-adica Class obj = new Class() in loc de asta lasam subclasele sa instantize creeze obj
metoda foloseste o metodaFactory pt astsa, daca e nevoie... Supertype obj = methodFactory*parametri*
All the responsibility for  instantiating Pizzas has been moved into a method that acts as a factory

pagina 172 - creator si productsCreator - diagrama explicativa cum functioneaza 
pagina 180 - explicatie privind inversion din Principle, adica in loc sa facem totul deodata, un top-to-bottom aproach, gandim ce putem abstractiza, atat in high level cat si in low level - DE RECITIT NEAPARAT O PAGINA




sophisticated techniques that can be used to make parameters more “type safe”—in other words, to ensure errors in parameters can be caught at compile time.
For instance, you can create objects that represent the parameter types, use static constants, or use enums


The factory design pattern is used when we have a superclass with multiple sub-classes and based on input, we need to return one of the sub-class. 
This pattern takes out the responsibility of the instantiation of a class from the client program to the factory class.
-deci avem o superclasa abstracta/interfata care e extinsa/impl de subclasele alea care de altfel ar fi class explosion
-iar apoi avem classFactory cu o instanta a superType-ului in metode, iar in functie de un parametru, intoarcem o anumita subclasa in supraType method class... - We can keep Factory class Singleton or we can keep the method that returns the subclass as static.
-iar in clasa client-ului, un magazin or whateva avem o instanta a factoryClass, si metode cu superType, iar in metoda apelam factoryClass metodaFactory cu parametrul din metodaSupertype din client
valueOf() - methodFactory


https://www.geeksforgeeks.org/factory-method-design-pattern-in-java/ - method factory - usor -> ai mai intalnit factories - aici e cu un pas in spate fata de clase, a subclasat Factory si a mutat logica creation obj in subclase
- notificationFactory -> ca si PizzaStoreFactory poate fi subclasata de oriceclasa si acolo cream clase concrete
but because Pizza is abstract, orderPizza() has no idea what real concrete classes are involved. In other words, it’s decoupled!
- pagina 163 imp


I have learned that one can encapsulate the code that creates objects. When you have code that instantiates concrete classes, this is an area of frequent change. I’ve learned a technique called “factories” that allows you to encapsulate this behavior of instantiation.
Guru: And these “factories,” of what benefit are they?
Student: There are many. By placing all my creation code in one object or method, I avoid duplication in my code and provide one place to perform maintenance. 
That also means clients depend only upon interfaces rather than the concrete classes required to instantiate objects. As I have learned in my studies, this allows me to program to an interface, not an implementation, and that makes my code more flexible and extensible in the future.


In the Abstract Factory pattern, we get rid of if-else block and have a factory class for each sub-class. Then an Abstract Factory class that will return the sub-class based on the input factory class - metoda factory fiind abstracta - decuplata
Abstract Factory design pattern provides approach to code for interface rather than implementation.
Abstract Factory pattern is “factory of factories” and can be easily extended to accommodate more products, for example we can add another sub-class Laptop and a factory LaptopFactory.
Abstract Factory pattern is robust and avoid conditional logic of Factory pattern.

sa recitesc...de la 180 la 200

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Singleton
-not to use 

cand folosim: obj ca thread pools, caching, preferences box, daca nu le-am folosi, am intampina probleme precum overuse of resources, inconsistent data, program behaving annormally

static method declarata intr-o clasa e o metoda a clasei - deci NumeleClasa.metodaStatica(); - cand o apelam
lazy instantion: if nu vrem niciodata o instanta, nu va fi niciodata creata

-private constructor


The Singleton Pattern ensures a class has only one instance, and provides a global point of access to it.
global point of access: Clasa.MetodaStatica - act as a global point acces
one instance: static SingletonClass 
\
daca 2 threaduri folosesc metoda statica si sngletonul in acelasi timp, se creaza 2 obj diferite in acelasi timp -> folosim synchronized pe metoda pt. a scapa de asta
sau:
 private static Singleton uniqueInstance = new Singleton();
 - eagerly created instance, thread safe -> Singleton getInstance() { return uniqueInstance;} - daca avem nevoie de calcul rapidd, daca nu, ramane synchronized
The JVM guarantees that the instance will be created before any thread accesses the static uniqueInstance variable

pagina 220 - exemplu cu Volatile
===> toate problemele astea se rezolva automat folosind un ENUM SINGLETON!
\

subclassing a Singleton - you cant! Constructorul e privat

init eager - cand cream instanta o data cu clasa private static final instance = new ...Singleton
dar in lazy init - o facem in the Global access to that singleton - adica in getInstance() method
enum not allow lazy init, dar ne scapa de reflection -
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-Command Pattern
Encapsuling Invocation - encapsule method invocationm

fara prea multe if-uri fara conditional statements -> Whenever a new vendor class comes out, we’d have to go in and modify the code, potentially creating bugs and more work for ourselves!


private Light light;
 public LightOnCommand(Light light) { //passing the instance of the Light what we re going to controllate and store it in the light instance variable - deci controlam o clasa dintr-o alta -> blueprints
 this.light = light;


Receiverul e clasa Light, clasa unde performam actiuni din comenzi

toStringMethod e apelat autmoat cand apelam obj unei clasei

pagina 242 - exemplu de workflow


IntefataComanda impl de o ConcreteComanda cu o instanta a ConcreteObj(Light for example...) iar in ConcreteComandaMethod invokam receiverul, adica ConcreteObj.methoda si acolo se face tot business logic-ul

parametrii dintr-o metoda actioneaza asupra clasei: this.classVar = parametruDinMethoda

 Command pattern is an object behavioral pattern that allows us to achieve complete decoupling between the sender and the receiver. (A sender is an object that invokes an operation, and a receiver is an object that receives the request to execute a certain operation. With decoupling, the sender has no knowledge of the Receiver's interface.) 
The term request here refers to the command that is to be executed
The Command pattern also allows us to vary when and how a request is fulfilled. Therefore, a Command pattern provides us flexibility as well as extensibility.
receiverul e instanta var din comands who implements Command interface
invoker e remoteControll

Simply put, the pattern intends to encapsulate in an object all the data required for performing a given action (command), including what method to call, the method's arguments, and the object to which the method belongs.
commands encapsulate all the information required
An invoker is an object that knows how to execute a given command but doesn't know how the command has been implemented. It only knows the command's interface.

pagina 252 - exemplu null obj pattern
254 - lambda exemplu

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
7 the Adapter and Facade Patterns - Being ADDAPTIVE
Adapter: - 279

public class DuckAdapter implements Turkey {
 Duck duck;
//methode specifice Turkey implementate... {duck.makeNoise;}  Now we are adapting Turkeys to Ducks, so we implement the Turkey interface.




My Software | Adapter | Vendor Classes
myAdapter implements an interface that mySoftwareClasses expect ... and talks to the vendor interface to manage my requests

The Adapter Pattern converts the interface of a class into another interface the clients expect. Adapter lets classes work together that couldn’t otherwise because of incompatible interfaces.


Client ->  REQUEST() ->  Adapter -> TRANSLATEDREQUEST() -> Adaptee
Explicatii:
-clientul nu poate apela metodele adaptatului in mod direct, ci prin AdapterClass.Request
-AdapterClass implementeaza interfata pe care clientul  o poate apela in mod direct, si are o  referinta catre Interfata implementata de  Obiectul ce urmeaza a fi adoptat pt. a putea fi apelat prin aceasta interfata, 
-adapterClass DI in constructor ca sa controlam clasa cu instanta, iar in metodele pe care le luam din Interfata care nu poate fi apelata in mod direct, apelam metodele pe care Clientul ar vrea sa le apeleze cu instanceVar.meethod();
 Cum functioneaza:
Clientul*main* apeleaza metoda din Adapter instantiind un obj din clasa Adaptor prin TargetInterface*interfata ce este implementata de AdapterClass*
Adapterul traduce metoda apelata din main in metode apelate catre clasa ce e Adaptata prin referinta catre interfata implementata de clasaAdaptata
Clientul*main* primeste rezultatul fara sa stie ca vb catre un adapter 

The Adapter Pattern’s role is to convert one interface into another
Definitie:
The Adapter Pattern converts the interface of a class into another interface the clients expect. Adapter lets classes work together that couldn’t otherwise because of  incompatible interfaces

-asta pana acum e Object Adapter, dar sunt de 2 tipuri, object(compositie deoarece are declarata o instanta a interfetei pe care clientul nu o poate folosi) and class adapter
class adapter necesita mostenire multipla != java (mostenire)

prin obj ADAPTER, avem flexibilitate, code nechanges si o multime de subclase de unde putem aleg
prin obj Adapter delegam metoda dintr-o parte in alta ca sa handluiasca

The Iterator’s hasNext() method is delegated to the Enumeration’s hasMoreElements() method...


Adapterul transforma interfetele ca sa poata fi folosite de catre clasa : always convert the interface that wrap, decoratorul nu o face niciodata
Decoratorul adauga noi responsabilitati catre clase
==adapteru schimba interfata, decoratorul nu, ambele wrap an obj

Decorator: doesn t alter the interface, but adds new Responsability
AdapterPattern - convert one interface to another
FacadePattern - simplify the interface



Facade Pattern:
practic reprezinta o interfata extinsa de o clasaFacade, aceasta clasa apeleaza cateva metode pe subsisteme  pe care le contine, in loc sa apelezi 10 metode separate in clase diferite, apelezi doar una din Facade iar facade le va apela pe restul
restul subsistemelor ramanand permisibile pt. noi sa le accesam daca vrem
daca nu,. folosim interfara simplificata -> FACADE
-poate adauga functionalitati noi la cere oferite deja de subsisteme daca e nevoie
-daca clientul are nevoie de ceva nou, schimba codul doar in facade nu in fiecare subclasa/subsistem in parte - decoupling

The difference between the two is not in terms of how many classes they “wrap,” it is in their intent. The intent of the Adapter Pattern is to alter an interface so that it matches one a client is expecting. 
The intent of the Facade Pattern is to provide a simplified interface to a subsystem.

chiar daca in Adapter we wrap an obj, in Facade we wrap many objects, but for the reason to create an interface and simplifying for the client that use it, decoupling that client from the subsystems
facade implementeaza o interfata cu metode, iar in implementare avem referinte catre obj Subsistemelor pe care le folosim ca apoi sa implementam metodele respective, apeland metodele din subsisteme\
-initiliazare in constructori pt. a le putea controla -> declaram o referinta var a unei clase, apoi in constructor legam referintele alea de instance var din parametri, in constructor, pt. a putea lega clasele si a actiona direct asupra lor


The Facade Pattern provides a unified interface to a set of interfaces in a subsystem. Facade defines a higherlevel interface that makes the subsystem easier to use. 

The Principle of Least Knowledge guides us to reduce the interactions between objects to just a few close “friends.”
Principle of Least Knowledge: talk only to your immediate friends
It means when you are designing a system, for any object, be careful of the number of classes it interacts with and also how it comes to interact with those classes.
This principle prevents us from creating designs that have a large number of classes coupled together so that changes in one part of the system cascade to other parts.
guidelines: take any object, and from any method in that object, invoke only methods that belong to: 
The object itself
? Objects passed in as a parameter to the method
? Any object the method creates or instantiates
? Any components of the object - instance variable - Has - A - Relationship
----> these guidliness ne spune sa nu apelam metode pe obiecte care sunt returnate apeland alte metode:\
Exemplu: 
-WITHOUT THE PRINCIPLE
public float getTemp() {
 Thermometer thermometer = station.getThermometer();  return thermometer.getTemperature(); } // astfel stim mai multe despre subsistem si n-ar trebui
-WITH THE PRINCIPLE 
public float getTemp() {  return station.getTemperature(); } in get temperature se apeleaza Thermometer - asa nu stim prea multe despre subsistem, e mai bine, decoupling,
pagina 307 - alt exemplu cu Design Principle
avantaje: decoupling, dezavantaje - too many wraper classes to handle methods call between classes -> incresed development time, decresed runtime performance
Law of Demeter == Least Know Principle - the same
Talk only to your close friends, not to friends of the friends *coupling*
<?> - work for any type of Object


=========================================================================



GOF
A pattern has 4 essential elements:
pattern name - ne ajuta vocabularul si sa ne intelegem mai usor intre colegi cand il spunem
problema pe care o rezolva acest design pattern - adica cand sa folosim acest design, cand intampinam problemele x, aplica pattern-ul y
solution to that problem - adica un template pe care sa-l folosim ca sa rezolvam acea problema,. solutie consta intre relatiile dintre obj, colaboratorii si cum sa cream aceste obj
consecintele pe care le dobandim cand aplicam acel design, mai departe trebe sa hotaram sa jonglam printre design-uri sau daca-l aplicam sau nu
--> trebe sa avem grija pt. ca in oo Design ne preocupa flexibilitatea, extensibilitatea si portabilitatea

MVC consists of three kinds of objects. The Model is the application object, the View is its screen presentation, and the Controller defines the way the user interface reacts to user input - decoupled them to increase flexibility and reusability

StrategyPattern
A Strategy is an object that represents an algorithm. It's useful when you want to replace the algorithm either statically or dynamically, when you have a lot of variants of the algorithm, or when the algorithm has complex data structures that you want to encapsulate.


Creational patterns concern the process of object creation. 
Structural patterns deal with the composition of classes or objects.
 Behavioral patterns characterize the ways in which classes or objects interact and distribute responsibility.


Creational class patterns defer some part of object creation to subclasses, while Creational object patterns defer it to another object. 
The Structural class patterns use inheritance to compose classes, while the Structural object patterns describe ways to assemble objects. 
The Behavioral class patterns use inheritance to describe algorithms and flow of control, whereas the Behavioral object patterns describe how a group of objects cooperate to perform a task that no single object can carry out alone

Incapsulare def:
Requests are the only way to get an object to execute an operation. Operations are the only way to change an object's internal data.
 Because of these restrictions, the object's internal state is said to be encapsulated; it cannot be accessed directly, and its representation is invisible from outside the object

Every operation declared by an object specifies the operation's name, the objects it takes as parameters, and the operation's return value. This is known as the operation's signature. 
The set of all signatures defined by an object's operations is called the interface to the object. 
An object's interface characterizesthe complete set of requests that can be sent to the object. Any request that matches a signature in the object's interface may be sent to the object
object of type Window*interface*

When a request issent to an object, the particular operation that'sperformed dependson both the request and the receiving object.
 Different objectsthat support identical requests may have different implementations of the operations that fulfill these requests. The run-time association of a request to an object and one of its operations is known as dynamic binding.
Dynamic binding means that issuing a request doesn't commit you to a particular implementation until run-time. 
Consequently, you can write programs that expect an object with a particular interface, knowing that any object that has the correct interface will accept the request.
 Moreover, dynamic binding lets you substitute objects that have identical interfaces for each other at run-time. This substitutability is known as polymorphism, and it's a key concept in object-oriented systems.
 It lets a client object make few assumptions about other objects beyond supporting a particular interface.
Polymorphism simplifies the definitions of clients, decouples objects from each other, and lets them vary their relationships to each other at run-time.

Objects are created by instantiating a class. The object is said to be an instance of the class. The process of instantiating a class allocates storage for the object's internal data (made up of instance variables) and associates the operations with these data. 
Many similar instances of an object can be created by instantiating a class.

An abstract class is one whose main purpose is to define a common interface for its subclasses. An abstract class will defer some or all of its implementation to operations defined in subclasses; hence an abstract class cannot be instantiated. 
The operations that an abstract class declares but doesn't implement are called abstract operations. Classes that aren't abstract are called concrete classes.
override let subclasses to handle parrent methods in subclasses way

It's also important to understand the difference between class inheritance and interface inheritance (or subtyping). Class inheritance defines an object's implementation in terms of another object's implementation.
 In short, it's a mechanism for code and representation sharing. In contrast, interface inheritance (orsubtyping) describes when an object can be used in place of another.

Class inheritance is basically just a mechanism for extending an application's functionality by reusing functionality in parent classes. It lets you define a new kind of object rapidly in terms of an old one - pagina 38 



-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Template Design Pattern - Encapsulating Algoritms

deci o metoda/algoritm care are in functionalitatea ei apelarea altor algoritmi, intr-un flow, step by step, like a Saga
cand avem code dublication along classes we need to abstract the commonality into a base class or interface


daca doua metode din 2 clase fac acelasi lucru, dar diferit in functie de clasa, o facem cumva abstracta/generala, ca sa poata fi doar una dar implementata in doua sau cate moduri vrea clasa respectiva
adica algoritm in clasa abstracta, cu metoda ca si template si metode in template, metodele ce se impl diferit in functie de clasa sunt abstracte
clasa abstracta {
final void prepareRecipe() { //final ca subclasele sa nu modifice template method
 boilWater();
 brew(); //putem apela metode abstracta in our template method, metode care sunt implementate in subclase in functie de comportamentul diferit al subclaselor
 pourInCup();		//abstract what vary from class to class
 addCondiments(); }

The Template Method defines the steps of an algorithm and allows subclasses to provide the implementation for one or more steps


Avantaje:
-code duplication less
- algoritm reside just in one place of app, if we need to change the algoritm, nu l schimbam in toate clasele, doar una
- pagina 328 pros and cons

The Template Method Pattern provides a framework that other caffeine beverages can be plugged into. New caffeine beverages only need to implement a couple of methods.

We can also have concrete methods that do nothing by default; we call these “hooks.” Subclasses are free to override these but don’t have to. - adica metode concrete ca si pas in algoritm
putem folosi hook ca sa schimbam flow-ul template-uluii, adica in template: if(hookMetoda*(( { then metodaAsta() }  e un hook deoarece metoda hookMetoda ori e empty ori are un default impl care poate fi override by subclase


ar trebui sa incapsulam cat mai mult metodele ce fac ceva, si sa le apelam apoi din alte metode - exemplu pagina 333
a hook can be used to conditionally control the flow of the algorithm in the abstract class

Use abstract methods when your subclass MUST provide an implementation of the method or step in the algorithm. Use hooks when that part of the algorithm is optional. With hooks, a subclass may choose to implement that hook, but it doesn’t have to.

There are a few uses of hooks. As we just said, a hook may provide a way for a subclass to implement an optional part of an algorithm, or if it isn’t important to the subclass’s implementation, it can skip it.
 Another use is to give the subclass a chance to react to some step in the template method that is about to happen or just happened

Design Principle: The Hollywood Principle: High Level component should t depend on low level componenet to get the job done,high level compoenent will call low levels when they need somethind
With the Hollywood Principle, we allow low-level components to hook themselves into a system, but the high-level components determine when they are needed, and how
CaffeineBeverage is our high-level component. It has control over the algorithm for the recipe, and calls on the subclasses only when they’re needed for an implementation of a method

Hollywood Principle mai e folosit in Factory Method and Oberver Pattern



The Dependency Inversion Principle teaches us to avoid the use of concrete classes and instead work as much as possible with abstractions. 
The Hollywood Principle is a technique for building frameworks or components so that lower-level components can be hooked into the computation, but without creating dependencies between the lower-level components and the higher-level layers. 
So, they both have the goal of decoupling, but the Dependency Inversion Principle makes a much stronger and more general statement about how to avoid dependencies in design. 

Example of Template Method: , the sort() template method in Arrays gives us the algorithm, but you need to tell it how to compare ducks, which you do by implementing the compareTo() method
-nu e neaparat sa folosim subclasarea, desi  e o cerinta importanta - la pagina 342 - ne arata ca desi sort e statica, si nu extindem superclasa, are o metoda concreta in template method sort, metoda pe care trebe sa-i impl interfata, deci ca sa ne folosim de sort, trebe sa impl Comparable si metoda ei

din nou,  chiar si un simplu for ar trebui sa-l facem in propria metoda
pagina 345 - exemplu de cod

in Strategy, the class that you compose with implements the entire algorithm. The algorithm that Arrays implements for sort() is incomplete; it needs a class to fill in the missing compareTo() method. So, in that way, it’s more like Template Method.

compositie > mostenire

pagina 347 - exemplu de AbstractList ce este extinda de Liste si metoda SubList - method pattern example whici relies on 2 metods implements in the subclasses

Template pattern:
define the outline of an algorithm, but let my subclasses do some of the work. That way, I can have different implementations of an algorithm’s individual steps, but keep control over the algorithm’s structure
superclass is abstract. - deoarece daca e nevoie sa definim anumite metode din algoritm, o facem in clasa abstracta, iar ce difera in functie de impl e impl in subclase
 The template method’s abstract class may define concrete methods, abstract methods, and hooks

The Hollywood Principle guides us to put decision making in highlevel modules that can decide how and when to call low-level modules
- ca subclasele sa nu modifice algoritmul superclasei, putem declara acel algoritm ca si final
strategy pattern si template pattern ambele incapsuleaza algoritmii, primul prin compozitie, al doilea prin mostenire

pagina 333 si 338 regardles of DI versus HollyWood principle


-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
9: The Iterator and Composite Patterns
Well Managed Collections

declaram Lista in instance var si o initializam in constructor fara parametri
nu mai declar listInstance.add in constructor ci intr-o metoda separata -> incapsulare, iar metoda e apelata cu parametri respectivi: Ex: addMethod(parametri) {   - pagina 358 exemplu, initializam aici obj constructorul pe care-l folosim in lista, cu parametrii proveniti din metoda, iar obj constructorul il adaugam apoi in lista - totul intr-o metoda -> incapsulare
-aici apelam metoda cu parametri prestabiliti in constructor pt. ca vrem o lista de-a gata, si ar fi oke asa, dar putem pune sa fie apelata metoda cu obj, nu neaparat sa o punem de-a gata in constructor

clasa cu parametri -> alta clasa ce foloseste clasa cu parametri intr-o Lista, iar de fiecare data cand trebe sa adauge obj in lista, trebe sa creeze obj al carui Clasa e Lista, adica: List<MenuItem> lista .... MenuItem obj = new MenuItem(parametri...);


folosim liste pt. dimensiuni dinamice, array pt. dimensiuni fizice si mereu trebe sa vedem daca nu obtinem NullPointerException...deci sa-i masuram lungimea

encapsulate what varies. - adica aici sunt cele 2 tip-uri de loop-uri pe care le avem: in lista si in array
mereu cand iteram sa fim atenti la size(), length() ca sa nu primim null pointer exception

//cat timp mai sunt elemente, obtinem urm element
while (iterator.hasNext()) { MenuItem menuItem = iterator.next();

COLLECTION we just mean a group of objects. They might be stored in very different data structures like lists, arrays, or hash maps, but they’re still collections. We also sometimes call these AGGREGATES

iterator e practic o interfata cu 2 metode, hasNext si next, interfata ce poate fi implementata de orice Colectia pt. a furniza un iterator pt. orice colectie de date...
in implementare verificam colectia de date, o iteram, iar in clasa unde avem colectia de date, declaram IteratorImpl cu metodele - pagina 366 - 368 exemplu

Pattern folositor - un fel de adapter pattern, cand avem 2 clase, 2 bucati de sistem dif, cu colectii de date diferite ce trebe folosite ambele intr-un singur loc
adica sa folosim acest iterator pt. cand vrem sa iteram oriunde, obj, liste, maps etc... 

The Menus are not well encapsulated; we can see the Diner is using an ArrayList and the Pancake House an Array - deci incapsularea e o ascundere a implementarii
All we need is a loop that polymorphically handles any collection of items as long as it implements Iterator

The Iterator allows the Waitress to be decoupled from the actual implementation of the concrete classes. She doesn’t need to know if a Menu is implemented with an Array, an ArrayList
-------------deci decuplare prin interfata
pagina 372 - 374 - > exemplu


The implementation is showing through: breakfast items are in an ArrayList, and lunch items are in an Array
size.lista ... listaobj.get(i), lenght.array... [i] in loop-uri pt. a le  printa

encapsulate what varies. It’s obvious what is changing here: the iteration caused by different collections of objects being returned from the menus - de la simple metode cu dif parametri care pot lua multe forme la orice nu e constant
The constructor takes the array of menu items we are going to iterate over =========DI


----> practic avem interfata iterator cu metode hasNext, next, remove the last element received from calling next method, dar listele si colectiile au deja o metoda numita iterator care returneaza un iterator
----> deci nu trebe sa impl Iterator interface, doar pt. arrays ca nu are iterator method...

Exception handling...
The remove() method is considered optional. You don’t have to provide remove functionality. But you should provide the method  because it’s part of the Iterator interface. 
If you’re not going to allow remove() in your iterator, you’ll want to throw the runtime exception java.lang.UnsupportedOperationException.
 The Iterator API documentation specifies that this exception may be thrown from remove() and any client that is a good citizen will check for this exception when calling the remove() method


in loc ca o clasa*Waitress* sa compose clase concrete, facem clasele concrete sa impl aceeasi interfata, cu metoda comuna, cate au... si in the Waitress we program to an interface not a concrete impl
=reducing dependency between obj



The implementation is showing through: breakfast items are in an ArrayList, and lunch items are in an Array - deci nu vrem sa aratam ce si cum, doar numele metodei

 encapsulate what varies


We’re returning the Iterator interface. The client doesn’t need to know how the MenuItems are maintained in the DinerMenu, nor does it need to know how the DinerMenuIterator is implemented.
 It just needs to use the iterators to step through the items in the menu

. If you’re not going to allow remove() in your iterator, you’ll want to throw the runtime exception java.lang.UnsupportedOperationException. The Iterator API documentation specifies that this exception may be thrown from remove() and any client that is a good citizen will check for this exception when calling the remove() method 



 problem of the Waitress depending on the concrete Menus. adica cand intr-o clasa folosim obj composition with concrete classes not interfaces...\
we solve this with:
The PancakeHouseMenu and DinerMenu classes implement an interface, Menu. 
This allows the Waitress to refer to each menu object using the interface rather than the concrete class. So, we’re reducing the dependency between the Waitress and the concrete classes by “programming to an interface, not an implementation.”
---> iar aici e pt. ca avem code duplication, adica aceeasi metoda pt. ambele, dar trebe impl in mod diferit
Also, the new Menu interface has one method, createIterator(), that is implemented by PancakeHouseMenu and DinerMenu. Each menu class massumes the responsibility of creating a concrete Iterator that is appropriate for its internal implementation of the menu items.


The Iterator Pattern provides a way to access the elements of an aggregate object sequentially without exposing its underlying representation
 once you have a uniform way of accessing the elements of all your aggregate objects, you can write polymorphic code that works with any of these aggregates—
just like the printMenu() method, which mdoesn’t care if the menu items are held in an Array or ArrayList (or anything else that can create an Iterator), as long as it can get hold of an Iterator.

when we allow a class to not only take care of its own business (managing some kind of aggregate) but also take on more responsibilities like iteration) then we’ve given the class two reasons to change.
Two? Yup, two: it can change if the collection changes in some way, and it can change if the way we iterate changes
---------------->
Design Principle: Single Responsability Principle: A class should have one reason to change
Every responsibility of a class is an area of potential change. More than one responsibility means more than one area of change.

Cohesion is a term you’ll hear used as a measure of how closely a class or a module supports a single purpose or responsibility.
We say that a module or class has high cohesion when it mis designed around a set of related mfunctions, and we say it has low mcohesion when it is designed around a set of unrelated functions
-deci related functions = srp

 Iterators imply no ordering
: When we write methods that take Iterators as parameters, we are using polymorphic iteration. 
That means we are creating code that can iterate over any collection as long as it supports Iterator.
We don’t care about how the collection is implemented, we can still write code to iterate over it

daca vrem sa adaugam functionalitate noua unei interfate  existente,  extindem acea interfata cu alta interfata, adaugam metodele, si clasa ce extinde interfara ce extinde se bucura de toate metodele

so all Collection classes are Iterables - collection interface implements Iterable, and Iterable interface has obj composition with Iterator

pagina 382 ne arata interarea clasica cu while, hasNext() si forEach loop, - de vazut si reinteles

colectiile ce sunt iterable folosesc forEach, arrays nu sunt

menuItems.values().iterator(); - not an iterator for the whole HashMap, just for the values...

decoupled from the implementation. - cand folosim interfete in clase ca si compozitie si nu concrete classes

Iterators imply no ordering. The underlying collections may be unordered as in a hash table or in a bag; they may even contain duplicates. So ordering is related to both the properties of the underlying collection and to the implementation
When we write methods that take Iterators as parameters, we are using polymorphic iteration. That means we are creating code that can iterate over any collection as long as it supports Iterator.
We don’t care about how the collection is implemented, we can still write code to iterate over it


All Collection classes, like ArrayList, implement the Collection interface, which inherits from the Iterable interface, so all Collection classes are Iterables. 
iterator() care returneaza un obj iterator, forEach si spliterator
the HashMap holds two sets of objects: keys and values. If we want to iterate over its values, we first need to retrieve them from the HashMap, and then obtain the iterator.


pagina 366 incepe codul - e usurel
The Menus are not well encapsulated; we can see the Diner is using an ArrayList and the Pancake House an Array
The Menu implementations are now encapsulated. The Waitress has no idea how the Menus hold their collection of menu items.
The Waitress is bound to concrete classes (MenuItem[] and ArrayList).


Now she doesn’t have to worry about which implementation we used; she always uses the same interface—Iterator—to iterate over menu items. She’s been decoupled from the implementation.


=====
The Composite Pattern

The Composite Pattern allows you to compose objects into tree structures to represent part-whole hierarchies. Composite lets clients treat individual objects and compositions of objects uniformly
adica un copac ierarhic - clasele fara subclase sunt numite leaf, iar cele cu subclase sunt numite noduri

pagina 399 - node tree structure
treat them uniformly. In other words, we can call the same method on menus or menu items.

We’ve used an abstract class here because we want to provide default implementations for these methods


 then any menu is a “composition” because it can contain both other menus and menu items - adica clasa in clasa in clasa
The Composite Pattern allows us to build structures of objects in the form of trees that contain both compositions of objects and individual objects as nodes.
operatiile/metodele pot fi aplicate tuturor sau doar in parti ale compositului

a composite tree is made of a composite interface/abstract class which defines a set of operations for leaf/nodes
a composte tree is made of lead or composite made of leafs or other composites

Menu extends MenuComponent...
... List<MenuComponent>....  Menu can have any number of children of type MenuComponent - abstractizare si polimorfism

pagina 409 de recitit, de asemenea sa vad din dou Waitress class

The composite object will display by telling all its components to display adica va apela recursiv metodele daca facem asta printr-o iterare
: In order for the composite to work transparently to the client, you must implement the same interface for all objects in the composite



-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
The State Pattern:

pagina 431 - exemplu discutie
state machine - acel obj se va comporta diferit in functie de ce in stare e
states and events or actions, events or actions change the state of the obj

replacement a conditional with polymorfical 

in metodele primite/actiuni/evente schimbam state-ul obj nostru
 
cand state-ul se schimba, si metodele ar trebui sa se schimbe, adica metodele dintr-o state sa fie diferite fata din alta state

delegam in Context, in metodele noastre ce necesita implementare, delegam catre interfata cu this.interfata.metoda catre concrete classes
initializam state-ul Contextului in the initial state, oricare ar fi ala, deci cand construim obj-ul nostru Context, va fi creat in the initial state - prin constructor fara parametri: this.state = new ConcreteInitialState(this) - give a reference to this obj, adica to this Context
------> deoarece ConcreteState-urile trebe sa aiba o referinta catre Context si Contextul o referinta catre State.... dualitate
--> iar in functie de state-ul obj-ului, delegam metodele catre concreteState classes care impl metodele intr-un anumit fel, in functie de ce State are obj-ul creat
----> mutation - putem schimba State-ul obj-ului dintr-o concreteState class: adica cand performam o actiune ce schimba starea: tranzactia a fost din PendingState in AcceptedState
------> ConcreteClasses ar trebui sa aiba o referinta nu catre o concreteContext ci catre o abstractizare...interfata -> don t couple with concrete classes, but interfaces for flexibility
asa scapam de if conditionals: if state is open, if state is accepted call that method -NU, deja stim in ce state ne aflam si ce metoda a fost apelata de Context, asa ca stim deja ce sa facem fara conditionari
-replacing the conditional with polymorfism

concreteState classes trebe sa schimbe state-ul obj dupa ce au facut business-ul intr-o metoda... -> this.context.changeState(new NextConcreteState(this.context));}
-> asa ca metoda in Context va lua un parametru de tip StateContext si il va seta in Context = this.contextState = State-ul interfata provenit ca argument din metoda;. si schimba State-ul obj curent

All states are just different configurations of the machine that behave in a certain way and need some action to take them to another state.

State Pattern seamana ft mult cu StrategyPattern ca si mod de constructie, dar intentiile difera

incapsuleaza ce variaza - State-ul e aici
delegate Context to the State prin instanceVar State in the Context -> composition favor

OpenClosedPrinciple: Closed each state for modification, and yet left the Gumball Machine open to extension by adding new state classes (and we’ll do this in a second)

The State Pattern allows an object to alter its behavior when its internal state changes. The object will appear to change its class
->Because the pattern encapsulates state into separate classes and delegates to the object representing the current state, we know that behavior changes along with the internal state

What does it mean for an object to “appear to change its class”? Think about it from the perspective of a client: if an object you’re using can completely change its behavior, then it appears to you that the object is actually instantiated from manother class.
 In reality, however, you know that we are using composition to give the appearance mof a class change by simply referencing different state objects

pagina 445 sa o recitesc - diferente dintre Strategy si State si 453




Given we had no common functionality to put into an abstract class, we went with an interface.

StatePattern - o Intefata State cu metodele/actiunile ce schimba State-ul unui obj/Context 
- apoi diferite ConcreteState impl State cu metodele respective specifice State-ului Respectiv, si business logic code in the actions, in constructor o referinta catre Context/obj
Un context, o clasa cu State ...various States, in constructor initializam State-ul in functie de ceva, intr-unul predefinit, iar cand primim o actiune, delegam prin state.methoda si schimbam si state-ul... setState
in plus, in constructor initializam toate state-urile posibile pt. context. state = new CevaState*this* - this context, obj

daca avem behaviour/metode care se repeta along the states, putem face interfata clasa abstracta cu anumite metode abstracte iar ce se repete sa fie among the states


Here we’re talking about a common technique: modeling state within an object by creating an instance variable to hold the state values and writing conditional code within our methods to handle the various states.

------------------------
Proxy
proxy apeleaza obj cu metodele pe care le vrem - -deci accesibilitate, nu accesam direct obj, ci prin proxy

sunt 3 tipuri de proxy: 
- remote proxy  - when we want to access something being out from our app - rmi
A remote proxy acts as a local representative to a remote object. What’s a “remote object”? It’s an object that lives in the heap of a different Java Virtual Machine (or more generally, a remote object that is running in a different address space).
What’s a “local representative”? It’s an object that you can call local methods on and have them forwarded on to the remote object.
- virtual proxy - controll access to an obj which is expensive to creaate - lazy inil
- protection proxy - access management - cu securitate

Clientul are o referinta catre ProxyConcreteClass, dar acest Proxy se crede a fi ObjReal, dar in schimb, el doar ofera metode si deleaga apelarea lor catre ObjReal, ProxyConcreteClass are o referinta catre RealObjClass;

RMI - cand Clasa noastra vrea sa apeleze ceva obj din altHeap, adica din alt JVM, adica din alt proiect :)
RMI gives us a way to find objects in a remote JVM and allows us to invoke their methods.
On the server side, the service helper receives the request from the client helper (through a Socket connection), unpacks the information about the call, and then invokes the real method on the real service object. So, to the service object, the call is local. It’s coming from the service helper, not a remote client
-adica (ObjCeAreNevoie -> ProxyObjCeAreNevoie = same JVM) -> (ProxyRealService -> RealService - different JVM, dar same local call for these);

in RMI, the client helper is a “stub” and the service helper is a “skeleton.”



Dependency: An object usually requires objects of other classes to perform its operations. We call these objects dependencies.
Injection: The process of providing the required dependencies to an object.
Thus dependency injection helps in implementing inversion of control (IoC). This means that the responsibility of object creation and injecting the dependencies is given to the framework (i.e. Spring) instead of the class creating the dependency objects by itself.
why to use DI Constructor
- All Required Dependencies Are Available at Initialization Time
- The IoC container makes sure that all the arguments provided in the constructor are available before passing them into the constructor. This helps in preventing the infamous NullPointerException



534 - exemplu de polimorfism, metoda initiala ia un obj de tip superType si apeleaza o metoda din ea, iar alte metode apeleaza metoda respectiva din metodele lor, cu subclasa supertype-ului, polimorfism - multe forme poate lua metoda





The Virtual Proxy pattern is a memory saving technique that recommends postponing an object creation until it is needed; it is used when creating an object the is expensive in terms of memory usage or processing involved.
https://www.javacodegeeks.com/2015/09/proxy-design-pattern.html - explicatia codului de la sf - practic incepe cu proxy, un obj null, iar doar atunci cand avem nevoie de metoda respectiva, proxy-ul va apela metoda din RealObj pt. a returna un rez


You’ll find a lot of variants of the Proxy Pattern in the real world; what they all have in common is that they intercept a method invocation that the client is making on the subject. 
This level of indirection allows us to do many things, including dispatching requests to a remote subject, providing a representative for an expensive object as it is created, or, as you’ll see, providing some level of protection that can determine which clients should be calling which methods

a decorator adds behavior to a class, while a proxy controls access to it.
Both Proxy and Adapter sit in front of other objects and forward requests to them. Remember that Adapter changes the interface of the objects it adapts, while Proxy implements the same interface



Java’s got its own proxy support right in the java.lang.reflect package. 
With this package, Java lets you create a proxy class on the fly that implements one or more interfaces and forwards method invocations to a class that you specify. 
Because the actual proxy class is created at runtime, we refer to this Java technology as a dynamic proxy.
- protection proxy - pagina  513 despre cum functioneaza


proxy is dynamic because its class is created at runtime. Think about it: before your code runs there is no proxy class; it is created on demand from the set of interfaces you pass it.
The proxy itself is created dynamically at runtime by the static Proxy.newProxyInstance() method. 

A Remote Proxy manages interaction between a client and a remote object.
? A Virtual Proxy controls access to an object that is expensive to instantiate.
? A Protection Proxy controls access to the methods of an object based on the caller.


Proxy is structurally similar to Decorator, but the two patterns differ in their purpose.
? The Decorator Pattern adds behavior to an object, while Proxy controls access.




------------------------------------------------------------------------
Patterns of Patterns
MCV

The controller does more than just “send it to the model”; it is responsible for interpreting the input and manipulating the model based on that input

Why we use Controller and not just View directly? ->
First, you’ll complicate your view code because it now has two responsibilities: managing the user interface and dealing with the logic of how to control the model.
Second, you’re tightly coupling your view to the model. If you want to reuse the view with another model, forget it. The controller separates the logic of control from the view and decouples the view from the model.
By keeping the view and controller loosely coupled, you are building a more flexible and extensible design, 

The controller is the strategy for the view—it’s the object that knows how to handle the user actions
iar Modelul e Observabilul observat de View sau Controller

ar trebui sa vorbim doar in abstractizari... ControllerInterface care sa ia orice  ControllerConcret vrem noi, ModelInterface etc
the controller implements behavior for the view

A Pattern is a solution to a problem in a context.

The context is the situation in which the pattern applies. This should be a recurring situation. - Avem o colectie de obj... - Iterator Pattern
The problem refers to the goal you are trying to achieve in this context, but it also refers to any constraints that occur in the context. - You need to step through the objects without exposing the collection’s implementation.
The solution is what you’re after: a general design that anyone can apply that resolves the goal and set of constraints. - Incapsulam Iterarea intr-o clasa separata

pagina 609 - cum sa te uiti la GOF si sa intelegi



structural patterns describe how classes and objects are composed to create new structures or new functionality.
The Decorator Pattern allows you to compose objects by wrapping one object with another to provide new functionality. 
So the focus is on how you compose the objects dynamically to gain functionality, rather than on the communication and interconnection between objects, which is the purpose of behavioral patterns.



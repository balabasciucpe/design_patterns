package com.balabasciuc.design_patterns.BehavioralPatterns.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements IObservable {

    private List<IObserve> observers; // a list of observators
    private float temperature;
    private float humidity;
    private float pressure;



    public WeatherData() {
        this.observers = new ArrayList<>();
    }




    @Override
    public void addObserver(IObserve iObserve) {
        observers.add(iObserve);
    }

    @Override
    public void removeObserver(IObserve iObserve) {
        observers.remove(iObserve);
    }

    @Override
    public void notifyObservers() {
        for (IObserve observer : observers)
        {
            observer.update(temperature, humidity, pressure);
        }
    }

    public void measurementsChanged()
    {
        notifyObservers();
    }

    //push
    public void setMeasurements(float temperature, float humidity, float pressure)
    {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }


}

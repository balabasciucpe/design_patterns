package com.balabasciuc.design_patterns.BehavioralPatterns.ObserverPattern;

public class CurrentConditionsDisplay implements IObserve, DisplayElement {

    private float temperature;
    private float humidity;

    private WeatherData weatherData;

    public CurrentConditionsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.addObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    @Override
    public void display()
    {
        System.out.println("Current conditions: temperature: " + temperature + "and humidity is: " + humidity);
    }
}

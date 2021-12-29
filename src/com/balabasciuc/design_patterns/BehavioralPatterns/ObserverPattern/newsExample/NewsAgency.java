package com.balabasciuc.design_patterns.BehavioralPatterns.ObserverPattern.newsExample;

import java.util.ArrayList;
import java.util.List;


//pulling example
public class NewsAgency implements ObservableInter {

    private String breakingNews;
    private List<IObserver> observerList;

    public NewsAgency()
    {
        observerList = new ArrayList<>();
    }



    @Override
    public void addObserver(IObserver iObserver) {
        this.observerList.add(iObserver);
    }

    @Override
    public void removeObserver(IObserver iObserver) {
        this.observerList.remove(iObserver);
    }

    @Override
    public void notifyObservers() {
        for (IObserver iObserver : observerList) {
            iObserver.update();
        }
    }

    public String getBreakingNews() {
        return breakingNews;
    }

    public void setBreakingNews(String news)
    {
        this.breakingNews = news;
        notifyChannels();
    }

    public void notifyChannels()
    {
        notifyObservers();
    }
}

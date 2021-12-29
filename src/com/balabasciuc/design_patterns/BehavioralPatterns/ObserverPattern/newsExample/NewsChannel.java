package com.balabasciuc.design_patterns.BehavioralPatterns.ObserverPattern.newsExample;

public class NewsChannel implements IObserver {


    private String latestNews;
    private NewsAgency newsAgency;

    public NewsChannel(NewsAgency newsAgency) {
        this.newsAgency = newsAgency;
        newsAgency.addObserver(this);
    }

    //pull
    @Override
    public void update() {
        this.latestNews = newsAgency.getBreakingNews();
        showNews();
    }

    public void showNews()
    {
        System.out.println("Our latest news is: " + latestNews);
    }
}

package com.fridaynightcommits.patterns.observer;

interface Subject {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}

package com.fridaynightcommits.patterns.observer.impl;

import com.fridaynightcommits.patterns.observer.DataElement;
import com.fridaynightcommits.patterns.observer.Observer;
import com.fridaynightcommits.patterns.observer.Subject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class DataProvider implements Subject {
    private List<Observer> observers;
    private DataElement dataElement;

    public DataProvider() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(dataElement);
        }
    }

    public List<Observer> getObservers() {
        return Collections.unmodifiableList(observers);
    }

    public DataElement getDataElement() {
        return dataElement;
    }

    public void setDataElement(DataElement dataElement) {
        this.dataElement = dataElement;
        notifyObservers();
    }
}

package com.fridaynightcommits.patterns.observer.impl;

import com.fridaynightcommits.patterns.observer.DataElement;
import com.fridaynightcommits.patterns.observer.Observer;

public class Subscriber implements Observer {

    private DataProvider provider;

    public DataElement getDataElement() {
        return dataElement;
    }

    public Subscriber(DataProvider provider) {
        this.provider = provider;
        this.provider.registerObserver(this);
    }

    public void unsubscribe() {
        provider.removeObserver(this);
    }

    private DataElement dataElement;

    @Override
    public void update(DataElement dataElement) {
        this.dataElement = dataElement;
    }

    @Override
    public String toString() {
        return "Subscriber{" +
                "dataElement=" + dataElement +
                '}';
    }
}

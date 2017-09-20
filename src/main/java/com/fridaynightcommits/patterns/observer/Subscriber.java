package com.fridaynightcommits.patterns.observer;

class Subscriber implements Observer {

    public DataElement getDataElement() {
        return dataElement;
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

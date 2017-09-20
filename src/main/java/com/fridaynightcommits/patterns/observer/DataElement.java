package com.fridaynightcommits.patterns.observer;

class DataElement {
    private int data;

    @Override
    public String toString() {
        return "DataElement{" +
                "data=" + data +
                '}';
    }

    public DataElement(int data) {
        this.data = data;
    }

    int getData() {
        return data;
    }
}

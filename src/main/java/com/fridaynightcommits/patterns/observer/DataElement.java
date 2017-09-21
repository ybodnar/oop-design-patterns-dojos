package com.fridaynightcommits.patterns.observer;

public class DataElement {
    private int data;

    public DataElement(int data) {
        this.data = data;
    }

    int getData() {
        return data;
    }

    @Override
    public String toString() {
        return "DataElement{" +
                "data=" + data +
                '}';
    }
}

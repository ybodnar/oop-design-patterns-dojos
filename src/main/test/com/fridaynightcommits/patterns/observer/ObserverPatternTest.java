package com.fridaynightcommits.patterns.observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;


class ObserverPatternTest {

    @Test
    void testObserverChange() {
        DataProvider dataProvider = new DataProvider();
        List<Subscriber> subscribers = Arrays.asList(new Subscriber(), new Subscriber());

        subscribers.forEach(dataProvider::registerObserver);

        DataElement sampleDataElement = new DataElement(1);
        dataProvider.setDataElement(sampleDataElement);
        subscribers.forEach((x) -> assertEquals(sampleDataElement, x.getDataElement()));

        DataElement sampleData_Element_2 = new DataElement(2);
        dataProvider.setDataElement(sampleData_Element_2);
        subscribers.forEach((x) -> assertEquals(sampleData_Element_2, x.getDataElement()));
    }

}
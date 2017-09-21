package com.fridaynightcommits.patterns.observer;

import com.fridaynightcommits.patterns.observer.impl.DataProvider;
import com.fridaynightcommits.patterns.observer.impl.Subscriber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ObserverPatternTest {
    private DataProvider dataProvider;
    private List<Subscriber> subscribers;
    private int numSubs;

    @BeforeEach
    void setUp() {
        dataProvider = new DataProvider();
        numSubs = getRandomInt();
        subscribers = generateSubscribers(dataProvider, numSubs);
    }

    @Test
    void testRegistration() {
        assertEquals(numSubs, dataProvider.getObservers().size());
    }

    @Test
    void testDeregistration() {
        Subscriber subscriber = subscribers.get(0);
        subscriber.unsubscribe();
        assertEquals(numSubs-1, dataProvider.getObservers().size());
        dataProvider.registerObserver(subscriber);
    }

    @Test
    void testObserversNotified() {
        DataElement sampleDataElement = new DataElement(1);
        dataProvider.setDataElement(sampleDataElement);
        subscribers.forEach((x) -> assertEquals(sampleDataElement, x.getDataElement()));

        DataElement sampleData_Element_2 = new DataElement(2);
        dataProvider.setDataElement(sampleData_Element_2);
        subscribers.forEach((x) -> assertEquals(sampleData_Element_2, x.getDataElement()));
    }

    private int getRandomInt() {
        return new Random(1L).nextInt(20);

    }

    private List<Subscriber> generateSubscribers(DataProvider dataProvider, int num) {
        List<Subscriber> subs = new ArrayList<>(num);
        for (int i = 1; i <= num; i++) {
            subs.add(new Subscriber(dataProvider));
        }
        return subs;
    }
}
package com.steamx3m.algorithms.structures;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class QueueTest {

    @Test
    public void pushNoOneElements() {
        Queue<Double> doubleStack = new Queue<>();

        assertEquals(doubleStack.toString(), "Queue{size=10, head=0, tail=0," +
                " array=[null, null, null, null, null, null, null, null, null, null]}");
    }

    @Test
    public void pushThreeElements() {
        Queue<Integer> integerQueue = new Queue<>();
        integerQueue.push(1);
        integerQueue.push(2);
        integerQueue.push(3);

        assertEquals(integerQueue.toString(), "Queue{size=10, head=3, tail=0," +
                " array=[1, 2, 3, null, null, null, null, null, null, null]}");
    }

    @Test
    public void pushElevenElements() {
        Queue<String> stringQueue = new Queue<>();
        stringQueue.push("1");
        stringQueue.push("2");
        stringQueue.push("3");
        stringQueue.push("4");
        stringQueue.push("5");
        stringQueue.push("6");
        stringQueue.push("7");
        stringQueue.push("8");
        stringQueue.push("9");
        stringQueue.push("10");
        stringQueue.push("11");

        assertEquals(stringQueue.toString(), "Queue{size=20, head=11, tail=0," +
                " array=[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, null, null, null, null, null, null, null, null, null]}");
    }

    @Test
    public void popFourElements() {
        Queue<Integer> integerQueue = new Queue<>(3);
        integerQueue.push(1);
        integerQueue.push(2);
        integerQueue.push(3);

        int popElement = integerQueue.poll();
        assertEquals(1, popElement);
        assertEquals(integerQueue.toString(), "Queue{size=3, head=3, tail=1, array=[null, 2, 3]}");

        popElement = integerQueue.poll();
        assertEquals(2, popElement);
        assertEquals(integerQueue.toString(), "Queue{size=2, head=1, tail=0, array=[3, null]}");

        popElement = integerQueue.poll();
        assertEquals(3, popElement);
        assertEquals(integerQueue.toString(), "Queue{size=2, head=1, tail=1, array=[null, null]}");

        try {
            popElement = integerQueue.poll();
            // недостижимое место!
            fail("что-то пошло не так!");
        } catch (NoSuchElementException ex) {
            assertEquals("There are no elements", ex.getMessage());
        }

        // добавим еще один элемент. вдруг после опустошения стека что-то сломалось
        integerQueue.push(4);
        assertEquals(integerQueue.toString(), "Queue{size=2, head=2, tail=1, array=[null, 4]}");
        // прверим что вытаскиваем этот элемент верно
        popElement = integerQueue.poll();
        assertEquals(4, popElement);
        assertEquals(integerQueue.toString(), "Queue{size=2, head=0, tail=0, array=[null, null]}");
    }


    @Test
    public void pollElevenElements() {
        Queue<Integer> integerQueue = new Queue<>(3);

        for (int i = 0; i < 11; i++) {
            integerQueue.push(i);
        }
        assertEquals(integerQueue
                             .toString(), "Queue{size=12, head=11, tail=0, array=[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, " +
                "null]}");

        for (int i = 0; i < 11; i++) {
            integerQueue.poll();
        }
        assertEquals(integerQueue.toString(), "Queue{size=4, head=0, tail=0, array=[null, null, null, null]}");


    }
}
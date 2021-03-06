package com.steamx3m.algorithms.structures;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class StackTest {

    @Test
    public void resize() {
        Stack<Integer> integerStack = new Stack<>(5);
        for (int i = 0; i < 20; i++) {
            integerStack.push(i);
        }

        for (int i = 0; i < 20; i++) {
            integerStack.pop();
        }

        assertEquals(integerStack.toString(),
                     "Stack{size=5, top=0, array=[null, null, null, null, null]}");
    }

    @Test
    public void pushNoOneElements() {
        Stack<Double> doubleStack = new Stack<>();

        assertEquals(doubleStack.toString(),
                     "Stack{size=10, top=0, array=[null, null, null, null, null, null, null, null, null, null]}");
    }

    @Test
    public void pushThreeElements() {
        Stack<Integer> integerStack = new Stack<>();
        integerStack.push(1);
        integerStack.push(2);
        integerStack.push(3);

        assertEquals(integerStack.toString(),
                     "Stack{size=10, top=3, array=[1, 2, 3, null, null, null, null, null, null, null]}");
    }

    @Test
    public void pushElevenElements() {
        Stack<String> stringStack = new Stack<>();
        stringStack.push("1");
        stringStack.push("2");
        stringStack.push("3");
        stringStack.push("4");
        stringStack.push("5");
        stringStack.push("6");
        stringStack.push("7");
        stringStack.push("8");
        stringStack.push("9");
        stringStack.push("10");
        stringStack.push("11");

        assertEquals(stringStack.toString(),
                     "Stack{size=20, top=11, " +
                             "array=[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, null, null, null, null, null, null, null, null, null]}");
    }

    @Test
    public void popThreeElements() {
        Stack<Integer> integerStack = new Stack<>(3);
        integerStack.push(1);
        integerStack.push(2);
        integerStack.push(3);

        int popElement = integerStack.pop();
        assertEquals(3, popElement);
        assertEquals(integerStack.toString(), "Stack{size=3, top=2, array=[1, 2, null]}");

        popElement = integerStack.pop();
        assertEquals(2, popElement);
        assertEquals(integerStack.toString(), "Stack{size=3, top=1, array=[1, null, null]}");

        popElement = integerStack.pop();
        assertEquals(1, popElement);
        assertEquals(integerStack.toString(), "Stack{size=3, top=0, array=[null, null, null]}");

        try {
            popElement = integerStack.pop();
            // недостижимое место!
            fail("что-то пошло не так!");
        } catch (NoSuchElementException ex) {
            assertEquals("There are no elements", ex.getMessage());
        }

        // добавим еще один элемент. вдруг после опустошения стека что-то сломалось
        integerStack.push(4);
        assertEquals(integerStack.toString(), "Stack{size=3, top=1, array=[4, null, null]}");
        // прверим что вытаскиваем этот элемент верно
        popElement = integerStack.pop();
        assertEquals(4, popElement);
        assertEquals(integerStack.toString(), "Stack{size=3, top=0, array=[null, null, null]}");
    }

    @Test
    public void popElevenElements() {
        Stack<Integer> integerStack = new Stack<>();

        for (int i = 0; i < 11; i++) {
            integerStack.push(i);
        }

        for (int i = 10; i >= 0; i--) {
            int element = integerStack.pop();
            assertEquals(i, element);
        }


        assertEquals(integerStack.toString(), "Stack{size=5, top=0, array=[null, null, null, null, null]}");
    }


}
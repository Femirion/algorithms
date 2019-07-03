package com.steamx3m.algorithms.structures;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Стек для любвых элементов
 * @param <T> тип элементов стека
 */
public class Stack<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private T[] array;
    private int top = 0;

    /**
     * Конструктор с указанием начальной вместительности
     *
     * @param capacity вместительность
     */
    @SuppressWarnings("There is not normal way for creating generic arrays")
    public Stack(int capacity) {
        array = (T[]) new Object[capacity];
    }

    /**
     * Конструктор c дефолтным размером = 10
     */
    @SuppressWarnings("There is not normal way for creating generic arrays")
    public Stack() {
        array = (T[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     * Добавить элемент в стек
     *
     * @param element добавляемый элемент
     */
    public void push(T element) {
        if (top >= array.length) {
            resize(array.length * 2);
            array[top++] = element;
        } else {
            array[top++] = element;
        }
    }

    /**
     * Получить верхний элемент стека
     * @return верхний элемент или если стек пуст то ошибка
     */
    public T pop() {
        if (top == 0) {
            throw new NoSuchElementException("There are no elements");

        }

        if (top < array.length / 4) {
            resize(array.length / 2);
        }

        top--;
        T element = array[top];
        // установим null чтобы не было утечек памяти
        array[top] = null;

        return element;
    }

    @Override
    public String toString() {
        return "Stack{" +
                "size=" + array.length +
                ", top=" + top +
                ", array=" + Arrays.toString(array) +
                '}';
    }

    private void resize(int newSize) {
        array = Arrays.copyOf(array, newSize);
    }
}

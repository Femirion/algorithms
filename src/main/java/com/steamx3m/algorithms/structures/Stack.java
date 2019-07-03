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
    private int size = 0;

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
        if (size >= array.length) {
            resize(array.length * 2);
            array[size++] = element;
        } else {
            array[size++] = element;
        }

    }

    /**
     * Получить верхний элемент стека
     * @return верхний элемент или если стек пуст то ошибка
     */
    public T pop() {
        if (size == 0) {
            throw new NoSuchElementException("There are no elements");

        }

        if (size < array.length / 4) {
            resize(array.length / 2);
        }

        // вычитаем 1 тк нумерация с 0
        return array[(size--) - 1];
    }

    @Override
    public String toString() {
        return "Stack{" +
                "array=" + Arrays.toString(array) +
                ", size=" + size +
                '}';
    }

    private void resize(int newSize) {
        array = Arrays.copyOf(array, newSize);
    }
}

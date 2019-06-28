package com.steamx3m.algorithms.structures;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Стек для любвых элементов
 * @param <T> тип дженерика
 */
public class Stack<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private T[] array;
    private int size = 0;
    private final String className;

    /**
     * Конструктор с классом и начальной вместительностью
     *
     * @param clazz класс
     * @param capacity вместительность
     */
    @SuppressWarnings("There is not normal way for creating generic arrays")
    public Stack(Class clazz, int capacity) {
        array = (T[]) Array.newInstance(clazz, capacity);
        className = clazz.getSimpleName();
    }

    /**
     * Конструктор с классом и начальной вместительностью.
     * По дефолту размер 10
     *
     * @param clazz класс
     */
    @SuppressWarnings("There is not normal way for creating generic arrays")
    public Stack(Class clazz) {
        array = (T[]) Array.newInstance(clazz, DEFAULT_CAPACITY);
        className = clazz.getSimpleName();
    }

    /**
     * Добавить элемент в стек
     *
     * @param element добавляемый элемент
     */
    public void push(T element) {
        if (size >= array.length) {
            int currentPosition = size;
            size++;
            array = Arrays.copyOf(array, size * 2);
            array[currentPosition++] = element;
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
            // нужно создать свое исключение и бросать его
            throw new RuntimeException("There are no elements");

        }

        // можно добавить автозжатие стека, если внутренний массив будет рассчитан
        // под 100 элементов, а pop вызвали 90 раз

        // вычитаем 1 тк нумерация с 0
        return array[(size--) - 1];
    }

    @Override
    public String toString() {
        return "Stack{" +
                "className=" + className +
                " array=" + Arrays.toString(array) +
                ", size=" + size +
                '}';
    }
}

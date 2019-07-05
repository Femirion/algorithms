package com.steamx3m.algorithms.structures;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Очередь
 * @param <T> тип элементов очереди
 */
public class Queue<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private T[] array;
    private int tail = 0;
    private int head = 0;

    /**
     * Конструктор с указанием начальной вместительности
     *
     * @param capacity вместительность
     */
    @SuppressWarnings("There is not normal way for creating generic arrays")
    public Queue(int capacity) {
        array = (T[]) new Object[capacity];
    }

    /**
     * Конструктор c дефолтным размером = 10
     */
    @SuppressWarnings("There is not normal way for creating generic arrays")
    public Queue() {
        array = (T[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     * Добавить элемент в очередь
     *
     * @param element добавляемый элемент
     */
    public void push(T element) {
        if (head >= array.length) {
            increase(array.length * 2);
            array[head++] = element;
        } else {
            array[head++] = element;
        }
    }

    /**
     * Получить первый элемент очереди
     * @return первый элемент или если очередь пусту то ошибка
     */
    public T poll() {
        if (tail == head) {
            throw new NoSuchElementException("There are no elements");

        }

        T element = array[tail];
        // установим null чтобы не было утечек памяти
        array[tail++] = null;

        if (tail > array.length / 2) {
            reduceSize(array.length / 2 + 1);
        }

        return element;
    }

    @Override
    public String toString() {
        return "Queue{" +
                "size=" + array.length +
                ", head=" + head +
                ", tail=" + tail +
                ", array=" + Arrays.toString(array) +
                '}';
    }

    private void increase(int newSize) {
        array = Arrays.copyOf(array, newSize);
    }

    /**
     * При уменьшении размера очереди используем другой механизм чем при увеличении.
     * Обусловлено тем что на момент вызова процедуры очередь имеет вид:
     * null-null-null-....-null-^tail=e1-e2-.....-^head=eN
     * Все элементы до указакателя tail нужно отбросить, это мусор
     * Все элементы e1-eN нужно скопировать в новый массив,
     * при этом длинна равняется разницей между головй и хвостом,
     * нумерация начинается с 0, tail указывается на нулевой элемент,
     *
     * @param newSize
     */
    private void reduceSize(int newSize) {
        T[] tmpArray = (T[]) new Object[newSize];
        System.arraycopy(array, tail, tmpArray, 0, head - tail);
        head = head - tail;
        tail = 0;
        array = tmpArray;
    }


}

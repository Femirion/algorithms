package com.steamx3m.algorithms.algorithms;

/**
 * Сортировка сравнением:
 * Сложность O(n^2)
 * Делаем n интераций, на каждой итерации проходим по массиву,
 * находим наименьший элемент и меняем местами его с элементом с i-тым индексом
 */
public class SelectionSort {

    public int[] sort(int[] source) {
        int min;
        int minIndex;
        for (int i = 0; i < source.length; i++) {
            min = source[i];
            minIndex = i;
            for (int j = i; j < source.length; j++) {
                int current = source[j];
                if (min > current) {
                    min = current;
                    minIndex = j;
                }
            }
            source[minIndex] = source[i];
            source[i] = min;
        }

        return source;
    }
}

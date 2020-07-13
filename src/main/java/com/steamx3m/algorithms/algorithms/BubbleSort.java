package com.steamx3m.algorithms.algorithms;

/**
 * Сортировка пузырьком:
 * Сложность O(n^2)
 * Делаем n интераций, на каждой итерации проходим по массиву,
 * и меняем два элемента местами, при условии что текущий элемент больше следующего
 */
public class BubbleSort {

    public int[] sort(int[] source) {
        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < source.length - 1; j++) {
                int current = source[j];
                int next = source[j + 1];
                if (current > next) {
                    source[j] = next;
                    source[j + 1] = current;
                }
            }
        }

        return source;
    }
}

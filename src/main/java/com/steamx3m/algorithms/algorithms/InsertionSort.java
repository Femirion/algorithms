package com.steamx3m.algorithms.algorithms;

/**
 * Сортировка вставками:
 * Сложность O(n^2)
 * Делаем n интераций, на каждой итерации проходим по массиву,
 * находим место в которое нужно вставить текущий элемент, если вставляем в середину,
 * то сдвигаем элементы вправо
 */
public class InsertionSort {

    public int[] sort(int[] source) {
        int current;
        int tmp;
        for (int i = 0; i < source.length; i++) {
            current = source[i];
            for (int j = 0; j < i; j++) {
                if (current < source[j]) {
                    tmp = source[j];
                    source[j] = current;
                    shift(source, j, i + 1);
                    source[j + 1] = tmp;
                    break;
                }
            }
        }

        return source;
    }

    /**
     * Процедура сдвига.
     * Идем по массиву, начиная с позиции startPosition в цикле передвигаем все элементы
     * на один вправо, до позиции shiftTillPosition. Первый элемент остается задублирован, тк
     * в дальнешейм на это место вставится другой элемент
     *
     * @param source исходный массив
     * @param startPosition позиция с которой начнется сдвиг
     * @param shiftTillPosition позиция на которой сдвиг закончится
     */
    private void shift(int[] source, int startPosition, int shiftTillPosition) {
        int current = source[startPosition];
        int tmp;
        for (int i = startPosition; i < shiftTillPosition - 1; i++) {
            tmp = source[i + 1];
            source[i + 1] = current;
            current = tmp;
        }
    }

}

package com.steamx3m.algorithms.utils;

import lombok.experimental.UtilityClass;

import java.util.Arrays;

@UtilityClass
public class TestUtils {

    public static boolean isSortedArray(int[] source) {
        for (int i = 0; i < source.length - 1; i++) {
            if (source[i] > source[i + 1]) {
                return false;
            }
        }

        return true;
    }

    public static int[] copyAndSort(int[] source) {
        int[] copy = new int[source.length];
        System.arraycopy(source, 0, copy, 0, source.length);
        Arrays.sort(copy);
        return copy;
    }
}

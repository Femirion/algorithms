package com.steamx3m.algorithms.utils;

import lombok.experimental.UtilityClass;

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
}

package com.steamx3m.algorithms.utils;

import lombok.experimental.UtilityClass;

import java.util.concurrent.ThreadLocalRandom;

@UtilityClass
public class ArrayGenerator {

    public static int[] generateInts(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = ThreadLocalRandom.current().nextInt(0, 1000);
        }
        return arr;
    }

}

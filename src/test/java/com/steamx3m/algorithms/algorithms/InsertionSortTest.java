package com.steamx3m.algorithms.algorithms;

import com.steamx3m.algorithms.utils.ArrayGenerator;
import org.junit.Test;

import java.util.Arrays;

import static com.steamx3m.algorithms.utils.TestUtils.copyAndSort;
import static com.steamx3m.algorithms.utils.TestUtils.isSortedArray;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class InsertionSortTest {
    private final InsertionSort subj = new InsertionSort();

    @Test
    public void empty_array() {
        int[] source = ArrayGenerator.generateInts(0);
        int[] expected = copyAndSort(source);

        int[] result = subj.sort(source);

        assertArrayEquals(expected, result);
        assertTrue(isSortedArray(result));
    }

    @Test
    public void one_element() {
        int[] source = ArrayGenerator.generateInts(1);
        int[] expected = copyAndSort(source);

        int[] result = subj.sort(source);

        assertArrayEquals(expected, result);
        assertTrue(isSortedArray(result));
    }

    @Test
    public void five_elements() {
        int[] source = ArrayGenerator.generateInts(5);
        int[] expected = copyAndSort(source);

        int[] result = subj.sort(source);

        assertArrayEquals(expected, result);
        assertTrue(isSortedArray(result));
    }

    @Test
    public void ten_elements() {
        int[] source = ArrayGenerator.generateInts(10);
        int[] expected = copyAndSort(source);

        int[] result = subj.sort(source);

        assertArrayEquals(expected, result);
        assertTrue(isSortedArray(result));
    }

    @Test
    public void ten_thousands_elements() {
        int[] source = ArrayGenerator.generateInts(10_000);
        int[] expected = copyAndSort(source);

        int[] result = subj.sort(source);

        assertArrayEquals(expected, result);
        assertTrue(isSortedArray(result));
    }

    @Test
    public void it_is_already_sorted() {
        int[] source = ArrayGenerator.generateInts(1000);
        Arrays.sort(source);
        int[] expected = copyAndSort(source);

        int[] result = subj.sort(source);

        assertArrayEquals(expected, result);
        assertTrue(isSortedArray(result));
    }
}
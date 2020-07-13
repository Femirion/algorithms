package com.steamx3m.algorithms.algorithms;

import com.steamx3m.algorithms.utils.ArrayGenerator;
import org.junit.Test;

import static com.steamx3m.algorithms.utils.TestUtils.isSortedArray;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class BubbleSortTest {

    private BubbleSort subj = new BubbleSort();

    @Test
    public void empty_array() {
        int[] source = ArrayGenerator.generateInts(0);

        int[] result = subj.sort(source);

        int[] expected = new int[0];
        assertArrayEquals(expected, result);
    }

    @Test
    public void one_element() {
        int[] source = ArrayGenerator.generateInts(1);

        int[] result = subj.sort(source);

        assertTrue(isSortedArray(result));
    }

    @Test
    public void three_elements() {
        int[] source = ArrayGenerator.generateInts(3);

        int[] result = subj.sort(source);

        assertTrue(isSortedArray(result));
    }

    @Test
    public void ten_thousands_elements() {
        int[] source = ArrayGenerator.generateInts(10_000);

        int[] result = subj.sort(source);

        assertTrue(isSortedArray(result));
    }

}
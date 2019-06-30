package com.steamx3m.algorithms.another;

import org.junit.Test;

import static org.junit.Assert.*;

public class StackEvaluatorTest {

    @Test
    public void checkResults() {
        StackEvaluator stackEvaluator = new StackEvaluator();

        double result = stackEvaluator.compute("( 1 + 1 )");
        assertEquals(2, result, 0.0001d);

        result = stackEvaluator.compute("( ( 6 * 2 ) + ( 1 * 8 ) )");
        assertEquals(20, result, 0.0001d);

        result = stackEvaluator.compute("( 12 / 4 )");
        assertEquals(3, result, 0.0001d);

        result = stackEvaluator.compute("( ( 10 - 1 ) * 2 )");
        assertEquals(18, result, 0.0001d);
    }

}
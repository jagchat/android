package com.samples.android.utils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void getSum_isCorrect() {
        Calc o = new Calc();
        int s = o.getSum(10,20);
        assertEquals(30, s);
    }
}
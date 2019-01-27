package com.zfy.main;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void binary_read_test() {
        int code = 345678;
        int index = 2;
        String s = Integer.toBinaryString(code);
        System.out.print(s);
        boolean result = false;
        String wd = s.split("")[index];
        if ("1".equals(wd)) {
            result = true;
        }
        assertTrue(result);
    }

    @Test
    public void binary_set_test() {
//        int index = 2;
//        boolean code = true;
//        String s = Integer.toBinaryString(code);
//        System.out.print(s);
//        boolean result = false;
//        String wd = s.split("")[index];
//        if ("1".equals(wd)) {
//            result = true;
//        }
//        assertTrue(result);
    }

}
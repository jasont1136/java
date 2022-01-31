package com.six311.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AbbreviateProductTest {

    @Test
    public void testProductRange() {
        assertEquals("24e0", AbbreviateProduct.apply(1, 4));
        assertEquals("399168e2", AbbreviateProduct.apply(2, 11));
    }

    @Test
    public void testProductRange_countTrailingZeros() {
        assertEquals(2, AbbreviateProduct.countTrailingZeros(100));
        assertEquals(2, AbbreviateProduct.countTrailingZeros(1234567800));
        assertEquals(0, AbbreviateProduct.countTrailingZeros(1234567801));
        assertEquals(4, AbbreviateProduct.countTrailingZeros(1234580000));
    }

    @Test
    public void testProductRange_tens() {
        assertEquals(10, AbbreviateProduct.tens(1));
        assertEquals(1000, AbbreviateProduct.tens(3));
        assertEquals(100000, AbbreviateProduct.tens(5));
        assertEquals(0, AbbreviateProduct.tens(0));
    }
}

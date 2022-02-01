package com.six311.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BuySellStockTest {

    @Test
    public void testBuySellStock() {
        {
            final int profitMargin = BuySellStock.apply(new int[]{7, 1, 5, 3, 6, 4});

            assertEquals(5, profitMargin);
        }

        {
            final int profitMargin = BuySellStock.apply(new int[]{7, 6, 4, 3, 1});

            assertEquals(0, profitMargin);
        }

        {
            final int profitMargin = BuySellStock.apply(new int[]{});

            assertEquals(0, profitMargin);
        }

    }
}

package com.six311.leetcode;

public class BuySellStock {

    public static int apply(final int[] prices) {

        if (prices.length == 0) {
            return 0;
        }

        int profitMargin = 0;
        int minPrice = prices[0];

        for (int i=1; i<prices.length; i++) {
            final int price = prices[i];

            final int currentProfit = price - minPrice;

            if (currentProfit > profitMargin) {
                profitMargin = currentProfit;
            }

            if (price < minPrice) {
                minPrice = price;
            }
        }

        return profitMargin;
    }
}

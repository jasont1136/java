package com.six311.leetcode;

import javax.annotation.Nonnull;

/**
 * You are given two positive integers left and right with left <= right.
 * Calculate the product of all integers in the inclusive range [left, right].
 *
 * ...
 *
 * https://leetcode.com/problems/abbreviating-the-product-of-a-range/
 */
public class AbbreviateProduct {

    @Nonnull
    public static String apply(final int left, final int right) {

        int total = left;

        for (int i=left+1; i<=right; i++) {
            total = (total * i);
        }

        final int count = countTrailingZeros(total);

        final int finalTotal;
        final String suffix;
        if (count > 0) {
            finalTotal = total/tens(count);
            suffix = "e" + count;
        }
        else {
            finalTotal = total;
            suffix = "e0";
        }

        return finalTotal + suffix;
    }

    static int countTrailingZeros(final int total) {
        int count = 0;
        int tens = 1;
        while (tens < total) {
            tens *= 10;
            if (total % tens > 0) {
                break;
            }
            count++;
        }
        return count;
    }

    static int tens(final int count) {
        if (count == 0) {
            return 0;
        }

        int tens = 1;
        for (int i=0; i<count; i++) {
            tens *= 10;
        }
        return tens;
    }
}

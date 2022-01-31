package com.six311.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class AddTwoNumbersTest {

    @Test
    public void testSumLists() {
        {
            final int[] l1 = new int[]{2, 4, 3};
            final int[] l2 = new int[]{5, 6, 4};

            final int[] result = AddTwoNumbers.apply(l1, l2);

            Arrays.stream(result).forEach(System.out::print);
            assertArrayEquals(new int[]{7, 0, 8}, result);
            System.out.println("");
        }

        {
            final int[] l1 = new int[]{6, 4, 3};
            final int[] l2 = new int[]{5, 6, 4};

            final int[] result = AddTwoNumbers.apply(l1, l2);

            Arrays.stream(result).forEach(System.out::print);
            assertArrayEquals(new int[]{1, 1, 8}, result);
            System.out.println("");
        }

        {
            final int[] l1 = new int[]{0};
            final int[] l2 = new int[]{0};

            final int[] result = AddTwoNumbers.apply(l1, l2);

            Arrays.stream(result).forEach(System.out::print);
            assertArrayEquals(new int[]{0}, result);
            System.out.println("");
        }

        {
            final int[] l1 = new int[]{9, 9, 9, 9, 9, 9, 9};
            final int[] l2 = new int[]{9, 9, 9, 9};

            final int[] result = AddTwoNumbers.apply(l1, l2);

            Arrays.stream(result).forEach(System.out::print);
            assertArrayEquals(new int[]{8, 9, 9, 9, 0, 0, 0, 1}, result);
            System.out.println("");
        }
    }
}

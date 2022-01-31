package com.six311.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class RotateArrayTest {

    @Test
    public void testRotateArray_right() {
        {
            final int[] rotated = RotateArray.right(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);

            assertArrayEquals(new int[]{5, 6, 7, 1, 2, 3, 4}, rotated);
        }

        {
            final int[] rotated = RotateArray.right(new int[]{-1, -100, 3, 99}, 2);

            assertArrayEquals(new int[]{3, 99, -1, -100}, rotated);
        }
    }

    @Test
    public void testRotateArray_left() {
        {
            final int[] rotated = RotateArray.left(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);

            assertArrayEquals(new int[]{4, 5, 6, 7, 1, 2, 3}, rotated);
        }

        {
            final int[] rotated = RotateArray.left(new int[]{-1, -100, 3, 99, 89}, 4);

            assertArrayEquals(new int[]{89, -1, -100, 3, 99}, rotated);
        }
    }

}

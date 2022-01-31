package com.six311.leetcode;

/**
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 *
 * https://leetcode.com/problems/rotate-array/
 */
class RotateArray {

    public static int[] right(final int[] a, final int k) {
        return rotate(a, k, a.length - k);
    }

    public static int[] left(final int[] a, final int k) {
        return rotate(a, k, k);
    }

    private static int[] rotate(final int[] a, final int k, final int startIndex) {

        int[] newA = new int[a.length];

        int readIndex = startIndex;

        for (int i=0; i<a.length; i++) {

            if (readIndex >= a.length) {
                // readIndex is greater than length, so start back at the beginning
                readIndex = 0;
            }

            newA[i] = a[readIndex];
            readIndex++;
        }

        return newA;
    }
}

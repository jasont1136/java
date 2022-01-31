package com.six311.leetcode;

import java.util.Arrays;

/**
 * Add Two Numbers
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {

    public static int[] apply(final int[] l1, final int[] l2) {

        int remainder = 0;

        final int maxLength = Math.max(l1.length, l2.length);

        final int[] result = new int[maxLength];

        for (int i=0; i<maxLength; i++) {

            final int l1Value = getValue(l1, i);
            final int l2Value = getValue(l2, i);

            final int sum = l1Value + l2Value + remainder;

            final int newValue;
            if (sum / 10 > 0) {
                remainder = sum / 10;
                newValue = sum % 10;
            } else {
                remainder = 0;
                newValue = sum;
            }

            result[i] = newValue;
        }

        final int[] finalResult;

        // make sure to account for any remainder left over
        if (remainder > 0) {
            finalResult = Arrays.copyOf(result, result.length+1);
            finalResult[finalResult.length-1] = remainder;
        }
        else {
            finalResult = result;
        }

        return finalResult;
    }

    private static int getValue(final int[] a, final int index) {
        if (index >= a.length) {
            return 0;
        }
        else {
            return a[index];
        }
    }
}

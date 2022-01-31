package com.six311.leetcode.mw;

import javax.annotation.Nullable;

/**
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every
 * character in t (including duplicates) is included in the window. If there is no such substring, return the
 * empty string "".
 *
 * https://leetcode.com/problems/minimum-window-substring/
 */
public class MinSubString {

    @Nullable
    public static String apply(final String s, final String t) {

        final int requiredLength = t.length();

        int presentCount = 0;
        int beginIndex = 0;
        int endIndex = 0;

        Result result = null;

        while (endIndex < s.length()) {
            final char c = s.charAt(endIndex);

            if (t.contains(String.valueOf(c))) {
                presentCount++;
            }

            if (presentCount >= requiredLength) {
                // all characters found in s

                if (result == null) {
                    result = new Result(beginIndex, endIndex);
                }
                else {
                    // result already exists, so check if this result is better

                    // First, shrink the window as much as possible
                    beginIndex = shrinkWindow(s, t, beginIndex, endIndex);

                    final Result newResult = new Result(beginIndex, endIndex);

                    // if new window is smaller than previous result, then replace it
                    if (result.getLength() > newResult.getLength()) {
                        result = newResult;
                    }
                }

                if (result.getLength() == requiredLength) {
                    // this is an ideal window, so break the loop
                    break;
                }

                presentCount--;
            }

            endIndex++;
        }

        if (result == null) {
            return null;
        }
        else {
            return s.substring(result.getBeginIndex(), result.getEndIndex()+1);
        }
    }

    // PRIVATE CLASSES/METHODS

    private static int shrinkWindow(final String s, final String t, final int beginIndex, final int endIndex) {

        int requiredLength = t.length();
        int presentCount = 0;
        int newBeginIndex = beginIndex;

        // work backwards from the end, as that will be more efficient
        for (int i=endIndex; i>=beginIndex; i--) {
            final char c = s.charAt(i);

            if (t.contains(Character.toString(c))) {
                presentCount++;
            }

            if (presentCount >= requiredLength) {
                newBeginIndex = i;
                break;
            }
        }

        return newBeginIndex;
    }
}

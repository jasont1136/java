package com.six311.leetcode;

public class AddSpaces {

    public static String apply(final String s, final int[] spaces) {


        final StringBuilder sb = new StringBuilder();

        int beginIndex = 0;

        for (final int index : spaces) {
            if (index < s.length()) {
                sb.append(s, beginIndex, index).append(" ");
                beginIndex = index;
            }
        }

        // Don't forget to add the end
        if (beginIndex < s.length()) {
            sb.append(s, beginIndex, s.length());
        }

        return sb.toString();
    }
}

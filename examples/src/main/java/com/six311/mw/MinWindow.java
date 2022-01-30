package com.six311.mw;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jasontewhau
 * @since 1/30/22
 */
public class MinWindow {

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
                    // result already exists, so check if window can be shrunk
                    beginIndex = shrinkWindow(s, t, beginIndex, endIndex);

                    final Result newResult = new Result(beginIndex, endIndex);

                    // if new window smaller than previous, then replace it
                    if (result.getLength() > newResult.getLength()) {
                        result = newResult;
                    }
                }

                if (result.getLength() == requiredLength) {
                    // this is an ideal window, so break
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

        // work backwards from the end
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

        public String minWindow(final String s, final String t) {

            if (s.length() == 0 || t.length() == 0) {
                return "";
            }

            // Dictionary which keeps a count of all the unique characters in t.
            final Map<Character, Integer> dictT = new HashMap<>();

            for (int i = 0; i < t.length(); i++) {
                final int count = dictT.getOrDefault(t.charAt(i), 0);
                dictT.put(t.charAt(i), count + 1);
            }

            // Number of unique characters in t, which need to be present in the desired window.
            final int required = dictT.size();

            // Left and Right pointer
            int l = 0, r = 0;

            // formed is used to keep track of how many unique characters in t
            // are present in the current window in its desired frequency.
            // e.g. if t is "AABC" then the window must have two A's, one B and one C.
            // Thus formed would be = 3 when all these conditions are met.
            int formed = 0;

            // Dictionary which keeps a count of all the unique characters in the current window.
            Map<Character, Integer> windowCounts = new HashMap<>();

            // ans list of the form (window length, left, right)
            int[] ans = {-1, 0, 0};

            while (r < s.length()) {
                // Add one character from the right to the window
                char c = s.charAt(r);
                int count = windowCounts.getOrDefault(c, 0);
                windowCounts.put(c, count + 1);

                // If the frequency of the current character added equals to the
                // desired count in t then increment the formed count by 1.
                if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
                    formed++;
                }

                // Try and contract the window till the point where it ceases to be 'desirable'.
                while (l <= r && formed == required) {
                    c = s.charAt(l);
                    // Save the smallest window until now.
                    if (ans[0] == -1 || r - l + 1 < ans[0]) {
                        ans[0] = r - l + 1;
                        ans[1] = l;
                        ans[2] = r;
                    }

                    // The character at the position pointed by the
                    // `Left` pointer is no longer a part of the window.
                    windowCounts.put(c, windowCounts.get(c) - 1);
                    if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
                        formed--;
                    }

                    // Move the left pointer ahead, this would help to look for a new window.
                    l++;
                }

                // Keep expanding the window once we are done contracting.
                r++;
            }

            return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
        }
}

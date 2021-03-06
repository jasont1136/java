package com.six311.leetcode;

/**
 * Calculates the minimum moves to reach target. Rules are:
 * - may double up to maxDoubles number of times
 * - unlimited increment by 1
 *
 * https://leetcode.com/problems/minimum-moves-to-reach-target-score/
 */
public class MinMoves {

    public static int apply(final int target, final int maxDoubles) {

        // Should start at the end, and burn the doubles as soon as possible
        // if there are no doubles left, then count will be (target - 1) + current count value

        int runningCount = 0;
        int runningTotal = target;
        int doublesAvailable = maxDoubles;

        while (runningTotal > 1 && doublesAvailable > 0) {

            // first try dividing by 2
            if (runningTotal % 2 == 0) {
                runningTotal = runningTotal / 2;
                runningCount++;
                doublesAvailable--;
            } else {
                // cannot divide evenly by 2, so decrement total by 1
                runningTotal--;
                runningCount++;
            }
        }

        // check if any runningTotal remaining, if so then increment runningCount by this value - 1
        if (runningTotal > 1) {
            runningCount += runningTotal - 1;
        }

        return runningCount;
    }
}

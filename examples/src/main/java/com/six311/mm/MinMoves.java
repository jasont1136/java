package com.six311.mm;

/**
 * @author jasontewhau
 * @since 1/31/22
 */
public class MinMoves {

    static int apply(final int target, final int maxDoubles) {

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
                // cannot divide evenly by 2, so reduce by 1 increment
                runningTotal--;
                runningCount++;
            }
        }

        // check if any runningTotal > 1 remaining, if so then increment runningCount by this much - 1
        if (runningTotal > 1) {
            runningCount += runningTotal - 1;
        }

        return runningCount;
    }
}

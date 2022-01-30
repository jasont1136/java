package com.six311.rt;

import java.util.Comparator;

/**
 * @author jasontewhau
 * @since 1/31/22
 */
public class RankComparator implements Comparator<Rank> {

    @Override
    public int compare(final Rank r1, final Rank r2) {

        int compare = 0;

        // Rule 1: highest score wins
        if (r1.getScore() < r2.getScore()) {
            compare = 1;
        }
        else if (r1.getScore() > r2.getScore()) {
            compare = -1;
        }
        else {
            // Rule 2: if scores the same, use count of position
            for (int i=0; i<r1.getMaxPositions(); i++) {
                if (r1.getPositionCount(i) < r2.getPositionCount(i)) {
                    compare = 1;
                    break;
                }
                else if (r1.getPositionCount(i) > r1.getPositionCount(i)) {
                    compare = -1;
                    break;
                }
            }

            // Rule 3: if ranks still the same, use name
            if (compare == 0) {
                compare = r1.getName().compareTo(r2.getName());
            }
        }

        return compare;
    }
}

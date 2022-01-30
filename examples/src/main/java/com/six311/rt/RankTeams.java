package com.six311.rt;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jasontewhau
 * @since 1/30/22
 */
class RankTeams {

    static String apply(final String[] votes) {

        final Map<Character, Rank> rankMap = new HashMap<>();

        for (final String vote : votes) {
            final char[] chars = vote.toCharArray();

            final int maxPositions = vote.length();

            for (int pos=0; pos<chars.length; pos++) {
                final char c = chars[pos];

                final Rank rank = rankMap.getOrDefault(c, new Rank(String.valueOf(c), maxPositions));

                // increment score, such that the score is higher based on the position
                // (example: 1st should get higher score than 2nd etc)
                rank.incrementScore(maxPositions-pos);
                rank.incrementPosition(pos);

                rankMap.put(c, rank);
            }
        }

        // Sort and return the final result. See RankComparator for sort rules
        final StringBuilder sb = new StringBuilder();
        rankMap.values().stream().sorted(new RankComparator()).forEach(x -> sb.append(x.getName()));

        return sb.toString();
    }
}

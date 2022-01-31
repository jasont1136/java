package com.six311.leetcode.rt;

import java.util.Arrays;

class Rank {

    private int score = 0;

    private final String name;
    private final int[] positionCounts;

    Rank(final String name, final int maxPositions) {
        this.name = name;
        this.positionCounts = new int[maxPositions];
    }

    String getName() {
        return this.name;
    }

    void incrementPosition(final int position) {
        positionCounts[position] = positionCounts[position] + 1;
    }

    void incrementScore(final int score) {
        this.score += score;
    }

    int getScore() {
        return score;
    }

    int getMaxPositions() {
        return positionCounts.length;
    }

    int getPositionCount(final int position) {
        return positionCounts[position];
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        Arrays.stream(positionCounts).forEach(sb::append);
        sb.append(" (").append(score).append(")");
        return sb.toString();
    }
}

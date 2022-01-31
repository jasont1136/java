package com.six311.mw;

final class Result {
    private final int length;
    private final int beginIndex;
    private final int endIndex;

    Result(final int beginIndex, final int endIndex) {
        this.beginIndex = beginIndex;
        this.endIndex = endIndex;
        this.length = (endIndex - beginIndex) + 1;
    }

    public int getLength() {
        return length;
    }

    public int getBeginIndex() {
        return beginIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }
}
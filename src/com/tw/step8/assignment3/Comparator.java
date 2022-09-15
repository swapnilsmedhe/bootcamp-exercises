package com.tw.step8.assignment3;

public class Comparator {
    public static ComparisonResult compare(Length firstLength, Length secondLength) {
        if (firstLength.isEqual(secondLength)){
            return ComparisonResult.EQUAL;
        }

        return firstLength.isGreaterThan(secondLength) ? ComparisonResult.GREATER : ComparisonResult.LESSER;
    }
}

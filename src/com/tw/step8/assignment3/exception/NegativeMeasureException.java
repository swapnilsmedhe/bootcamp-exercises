package com.tw.step8.assignment3.exception;

public class NegativeMeasureException extends Throwable {
    private final double length;

    public NegativeMeasureException(double length) {
        this.length = length;
    }

    @Override
    public String getMessage() {
        return String.format("Invalid length %f", length);
    }
}

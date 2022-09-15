package com.tw.step8.assignment3.exception;

public class InvalidLengthException extends Throwable {
    private final double length;

    public InvalidLengthException(double length) {
        this.length = length;
    }

    @Override
    public String getMessage() {
        return String.format("Invalid length %f", length);
    }
}

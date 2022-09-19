package com.tw.step8.assignment5;

public class NegativeCapacityException extends Throwable {
    private int capacity;

    public NegativeCapacityException(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String getMessage() {
        return String.format("Capacity cannot be negative %d" , capacity);
    }
}

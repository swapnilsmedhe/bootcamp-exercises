package com.tw.step8.assignment2.exception;

import java.util.Objects;

public class InvalidProbabilityException extends Throwable {
    private final double probability;

    public InvalidProbabilityException(double probability) {
        this.probability = probability;
    }

    @Override
    public String getMessage() {
        return String.format("Invalid probability %f", probability);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvalidProbabilityException that = (InvalidProbabilityException) o;
        return Double.compare(that.probability, probability) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(probability);
    }
}

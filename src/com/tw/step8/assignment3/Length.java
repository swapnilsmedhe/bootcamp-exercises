package com.tw.step8.assignment3;

import com.tw.step8.assignment3.exception.InvalidLengthException;
import java.util.Objects;

public class Length {
    private final double value;
    private final Unit unit;

    private Length(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public static Length create(double value, Unit unit) throws InvalidLengthException {
        if (value < 0) {
            throw new InvalidLengthException(value);
        }
        return new Length(value, unit);
    }

    private double toCentimeter() {
        return this.value * this.unit.centimeterConstant;
    }

    public boolean isEqual(Length otherLength) {
        return this.toCentimeter() == otherLength.toCentimeter();
    }

    public boolean isGreaterThan(Length otherLength) {
        return this.toCentimeter() > otherLength.toCentimeter();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Length length = (Length) o;
        return Double.compare(length.value, value) == 0 && unit == length.unit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, unit);
    }

}

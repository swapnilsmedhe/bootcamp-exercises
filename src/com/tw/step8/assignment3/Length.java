package com.tw.step8.assignment3;

import com.tw.step8.assignment3.exception.InvalidLengthException;
import java.util.Objects;

public class Length {
    private final double value;
    private final LengthUnit unit;

    private Length(double value, LengthUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    public static Length create(double value, LengthUnit unit) throws InvalidLengthException {
        if (value < 0) {
            throw new InvalidLengthException(value);
        }
        return new Length(value, unit);
    }

    private double toInch() {
        return this.value * this.unit.inchConstant;
    }

    public boolean isEqual(Length otherLength) {
        return this.toInch() == otherLength.toInch();
    }

    public boolean isGreaterThan(Length otherLength) {
        return this.toInch() > otherLength.toInch();
    }

    public ComparisonResult compare(Length otherLength) {
        if (this.isEqual(otherLength)){
            return ComparisonResult.EQUAL;
        }

        return this.isGreaterThan(otherLength) ? ComparisonResult.GREATER : ComparisonResult.LESSER;
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

    public Length add(Length otherLength) throws InvalidLengthException {
        double result =  this.toInch() + otherLength.toInch();
        return Length.create(result, LengthUnit.INCH);
    }
}

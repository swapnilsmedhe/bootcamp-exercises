package com.tw.step8.assignment3;

import java.util.Objects;

public class Length {
    private final double value;
    private final Unit unit;

    public Length(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    private double toCentimeter() {
        return this.value * this.unit.centimeterConstant;
    }

    public boolean isEqual(Length otherLength) {
        return this.toCentimeter() == otherLength.toCentimeter();
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

package com.tw.step8.assignment3;

import com.tw.step8.assignment2.Chance;
import com.tw.step8.assignment3.exception.NegativeMeasureException;

import java.util.Objects;

public class Volume {
    private final double value;
    private final VolumeUnit unit;

    private Volume(double value, VolumeUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    static Volume create(double value, VolumeUnit unit) throws NegativeMeasureException {
        if (value < 0) {
            throw new NegativeMeasureException(value);
        }
        return new Volume(value, unit);
    }

    private double toLiters() {
        return this.value * this.unit.literConstant;
    }

    public boolean isEqual(Volume otherVolume) {
        return this.toLiters() == otherVolume.toLiters();
    }

    public boolean isGreaterThan(Volume otherVolume) {
        return this.toLiters() > otherVolume.toLiters();
    }

    public ComparisonResult compare(Volume otherVolume) {
        if (this.isEqual(otherVolume)){
            return ComparisonResult.EQUAL;
        }

        return this.isGreaterThan(otherVolume) ? ComparisonResult.GREATER : ComparisonResult.LESSER;
    }

    public Volume add(Volume otherVolume) throws NegativeMeasureException {
        double result = this.toLiters() + otherVolume.toLiters();
        return Volume.create(result, VolumeUnit.LITER);
    }

    public boolean isDifferenceLessThanDelta(Volume otherVolume, double delta) {
        double difference = Math.abs(this.value - otherVolume.value);
        return difference < delta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Volume volume = (Volume) o;
        return Double.compare(volume.value, value) == 0 && unit == volume.unit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, unit);
    }
}

package com.tw.step8.assignment3;

public class Volume {
    private final double value;
    private final VolumeUnit unit;

    private Volume(double value, VolumeUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    static Volume create(double value, VolumeUnit unit) {
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
}

package com.tw.step8.assignment3;

public enum LengthUnit {
    INCH(1),
    FEET(12),
    CM(0.4),
    MM(0.04);

    public final double inchConstant;

    LengthUnit(double inchConstant) {
        this.inchConstant = inchConstant;
    }
}

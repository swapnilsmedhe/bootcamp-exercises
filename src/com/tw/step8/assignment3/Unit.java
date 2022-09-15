package com.tw.step8.assignment3;

public enum Unit {
    INCH(2.54),
    FEET(30.48);

    public final double centimeterConstant;

    Unit(double centimeterConstant) {
        this.centimeterConstant = centimeterConstant;
    }
}

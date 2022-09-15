package com.tw.step8.assignment3;

public enum Unit {
    INCH(2.5),
    FEET(30),
    CM(1),
    MM(0.1);

    public final double centimeterConstant;

    Unit(double centimeterConstant) {
        this.centimeterConstant = centimeterConstant;
    }
}

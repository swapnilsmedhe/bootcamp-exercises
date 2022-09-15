package com.tw.step8.assignment3;

public enum VolumeUnit {
    GALLON(3.78), LITER(1);

    public final double literConstant;

    VolumeUnit(double literConstant) {
        this.literConstant = literConstant;
    }
}

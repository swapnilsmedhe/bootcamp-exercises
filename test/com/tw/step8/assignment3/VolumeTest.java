package com.tw.step8.assignment3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VolumeTest{
    @Test
    void compareEqualityOfTwoVolumes() {
        Volume gallon = Volume.create(1, VolumeUnit.GALLON);
        Volume liters = Volume.create(3.78, VolumeUnit.LITER);

        assertTrue(gallon.isEqual(liters));
    }

    @Test
    void compareOneVolumeGreaterThanOther() {
        Volume oneGallon = Volume.create(1, VolumeUnit.GALLON);
        Volume threeLiters = Volume.create(3, VolumeUnit.LITER);

        assertTrue(oneGallon.isGreaterThan(threeLiters));
    }
}
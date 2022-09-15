package com.tw.step8.assignment3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VolumeTest{
    @Test
    void checkEqualityOfTwoVolumes() {
        Volume gallon = Volume.create(1, VolumeUnit.GALLON);
        Volume liters = Volume.create(3.78, VolumeUnit.LITER);

        assertTrue(gallon.isEqual(liters));
    }

    @Test
    void checkOneVolumeGreaterThanOther() {
        Volume oneGallon = Volume.create(1, VolumeUnit.GALLON);
        Volume threeLiters = Volume.create(3, VolumeUnit.LITER);

        assertTrue(oneGallon.isGreaterThan(threeLiters));
    }

    @Test
    void compareEqualityOfTwoVolumes() {
        Volume gallon = Volume.create(1, VolumeUnit.GALLON);
        Volume liters = Volume.create(3.78, VolumeUnit.LITER);

        assertEquals(ComparisonResult.EQUAL, gallon.compare(liters));
    }

    @Test
    void compareOneVolumeGreaterThanOther() {
        Volume gallon = Volume.create(2, VolumeUnit.GALLON);
        Volume liters = Volume.create(3.78, VolumeUnit.LITER);

        assertEquals(ComparisonResult.GREATER, gallon.compare(liters));
    }

    @Test
    void compareOneVolumeLesserThanOther() {
        Volume gallon = Volume.create(1, VolumeUnit.GALLON);
        Volume liters = Volume.create(5, VolumeUnit.LITER);

        assertEquals(ComparisonResult.LESSER, gallon.compare(liters));
    }
}

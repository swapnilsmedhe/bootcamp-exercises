package com.tw.step8.assignment3;

import com.tw.step8.assignment3.exception.NegativeMeasureException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VolumeTest{
    @Test
    void checkEqualityOfTwoVolumes() throws NegativeMeasureException {
        Volume gallon = Volume.create(1, VolumeUnit.GALLON);
        Volume liters = Volume.create(3.78, VolumeUnit.LITER);

        assertTrue(gallon.isEqual(liters));
    }

    @Test
    void checkOneVolumeGreaterThanOther() throws NegativeMeasureException {
        Volume oneGallon = Volume.create(1, VolumeUnit.GALLON);
        Volume threeLiters = Volume.create(3, VolumeUnit.LITER);

        assertTrue(oneGallon.isGreaterThan(threeLiters));
    }

    @Test
    void compareEqualityOfTwoVolumes() throws NegativeMeasureException {
        Volume gallon = Volume.create(1, VolumeUnit.GALLON);
        Volume liters = Volume.create(3.78, VolumeUnit.LITER);

        assertEquals(ComparisonResult.EQUAL, gallon.compare(liters));
    }

    @Test
    void compareOneVolumeGreaterThanOther() throws NegativeMeasureException {
        Volume gallon = Volume.create(2, VolumeUnit.GALLON);
        Volume liters = Volume.create(3.78, VolumeUnit.LITER);

        assertEquals(ComparisonResult.GREATER, gallon.compare(liters));
    }

    @Test
    void compareOneVolumeLesserThanOther() throws NegativeMeasureException {
        Volume gallon = Volume.create(1, VolumeUnit.GALLON);
        Volume liters = Volume.create(5, VolumeUnit.LITER);

        assertEquals(ComparisonResult.LESSER, gallon.compare(liters));
    }

    @Test
    void addTwoVolumes() throws NegativeMeasureException {
        Volume oneGallon = Volume.create(1, VolumeUnit.GALLON);
        Volume oneLiter = Volume.create(1, VolumeUnit.LITER);

        Volume expectedVolume = Volume.create(4.78, VolumeUnit.LITER);
        Volume actualVolume = oneGallon.add(oneLiter);

        assertTrue(expectedVolume.isDifferenceLessThanDelta(actualVolume, 0.001));
    }

    @Test
    void throwAnExceptionWhenProvidedNegativeValue() {
        assertThrows(NegativeMeasureException.class, ()-> Volume.create(-7, VolumeUnit.LITER));
    }
}

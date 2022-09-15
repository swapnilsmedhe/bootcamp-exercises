package com.tw.step8.assignment3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthTest {
    @Test
    void createALength() {
        Length inch1 = new Length(5, Unit.INCH);
        Length inch2 = new Length(5, Unit.INCH);

        assertEquals(inch1, inch2);
    }

    @Test
    void compareInchAndFootForEquality() {
        Length twelveInches = new Length(12, Unit.INCH);
        Length oneFeet = new Length(1, Unit.FEET);

        Length fiveInches = new Length(5, Unit.INCH);
        Length threeFeet = new Length(3, Unit.FEET);

        assertTrue(twelveInches.isEqual(oneFeet));
        assertFalse(fiveInches.isEqual(threeFeet));
    }

    @Test
    void compareInchAndCentimeterForEquality() {
        Length twoInches = new Length(2, Unit.INCH);
        Length fiveCentimeters = new Length(5, Unit.CM);

        Length oneInch = new Length(1, Unit.INCH);
        Length twoCentimeters = new Length(2, Unit.CM);

        assertTrue(twoInches.isEqual(fiveCentimeters));
        assertFalse(oneInch.isEqual(twoCentimeters));
    }

    @Test
    void compareCentimeterAndMillimeterForEquality() {
        Length oneCentimeter = new Length(1, Unit.CM);
        Length tenMillimeters = new Length(10, Unit.MM);

        Length fiveCentimeter = new Length(5, Unit.CM);
        Length fifteenMillimeters = new Length(15, Unit.MM);

        assertTrue(oneCentimeter.isEqual(tenMillimeters));
        assertFalse(fiveCentimeter.isEqual(fifteenMillimeters));
    }

    @Test
    void compareMillimeterAndInchForEquality() {
        Length hundredMillimeters = new Length(100, Unit.MM);
        Length fourInches = new Length(4, Unit.INCH);

        Length twoHundredMillimeters = new Length(200, Unit.MM);
        Length fiveInches = new Length(5, Unit.INCH);

        assertTrue(hundredMillimeters.isEqual(fourInches));
        assertFalse(twoHundredMillimeters.isEqual(fiveInches));
    }
}

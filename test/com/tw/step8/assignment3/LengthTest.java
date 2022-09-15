package com.tw.step8.assignment3;

import com.tw.step8.assignment3.exception.InvalidLengthException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthTest {
    @Test
    void createALength() throws InvalidLengthException {
        Length inch1 = Length.createLength(5, Unit.INCH);
        Length inch2 = Length.createLength(5, Unit.INCH);

        assertEquals(inch1, inch2);
    }

    @Test
    void compareInchAndFootForEquality() throws InvalidLengthException {
        Length twelveInches = Length.createLength(12, Unit.INCH);
        Length oneFeet = Length.createLength(1, Unit.FEET);

        Length fiveInches = Length.createLength(5, Unit.INCH);
        Length threeFeet = Length.createLength(3, Unit.FEET);

        assertTrue(twelveInches.isEqual(oneFeet));
        assertFalse(fiveInches.isEqual(threeFeet));
    }

    @Test
    void compareInchAndCentimeterForEquality() throws InvalidLengthException {
        Length twoInches = Length.createLength(2, Unit.INCH);
        Length fiveCentimeters = Length.createLength(5, Unit.CM);

        Length oneInch = Length.createLength(1, Unit.INCH);
        Length twoCentimeters = Length.createLength(2, Unit.CM);

        assertTrue(twoInches.isEqual(fiveCentimeters));
        assertFalse(oneInch.isEqual(twoCentimeters));
    }

    @Test
    void compareCentimeterAndMillimeterForEquality() throws InvalidLengthException {
        Length oneCentimeter = Length.createLength(1, Unit.CM);
        Length tenMillimeters = Length.createLength(10, Unit.MM);

        Length fiveCentimeter = Length.createLength(5, Unit.CM);
        Length fifteenMillimeters = Length.createLength(15, Unit.MM);

        assertTrue(oneCentimeter.isEqual(tenMillimeters));
        assertFalse(fiveCentimeter.isEqual(fifteenMillimeters));
    }

    @Test
    void compareMillimeterAndInchForEquality() throws InvalidLengthException {
        Length hundredMillimeters = Length.createLength(100, Unit.MM);
        Length fourInches = Length.createLength(4, Unit.INCH);

        Length twoHundredMillimeters = Length.createLength(200, Unit.MM);
        Length fiveInches = Length.createLength(5, Unit.INCH);

        assertTrue(hundredMillimeters.isEqual(fourInches));
        assertFalse(twoHundredMillimeters.isEqual(fiveInches));
    }

    @Test
    void throwInvalidLengthException() {
        assertThrows(InvalidLengthException.class, () -> Length.createLength(-2, Unit.FEET));
    }
}

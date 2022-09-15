package com.tw.step8.assignment3;

import com.tw.step8.assignment3.exception.InvalidLengthException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthTest {
    @Test
    void createALength() throws InvalidLengthException {
        Length inch1 = Length.create(5, LengthUnit.INCH);
        Length inch2 = Length.create(5, LengthUnit.INCH);

        assertEquals(inch1, inch2);
    }

    @Test
    void compareInchAndFootForEquality() throws InvalidLengthException {
        Length twelveInches = Length.create(12, LengthUnit.INCH);
        Length oneFeet = Length.create(1, LengthUnit.FEET);

        Length fiveInches = Length.create(5, LengthUnit.INCH);
        Length threeFeet = Length.create(3, LengthUnit.FEET);

        assertTrue(twelveInches.isEqual(oneFeet));
        assertFalse(fiveInches.isEqual(threeFeet));
    }

    @Test
    void compareInchAndCentimeterForEquality() throws InvalidLengthException {
        Length twoInches = Length.create(2, LengthUnit.INCH);
        Length fiveCentimeters = Length.create(5, LengthUnit.CM);

        Length oneInch = Length.create(1, LengthUnit.INCH);
        Length twoCentimeters = Length.create(2, LengthUnit.CM);

        assertTrue(twoInches.isEqual(fiveCentimeters));
        assertFalse(oneInch.isEqual(twoCentimeters));
    }

    @Test
    void compareCentimeterAndMillimeterForEquality() throws InvalidLengthException {
        Length oneCentimeter = Length.create(1, LengthUnit.CM);
        Length tenMillimeters = Length.create(10, LengthUnit.MM);

        Length fiveCentimeter = Length.create(5, LengthUnit.CM);
        Length fifteenMillimeters = Length.create(15, LengthUnit.MM);

        assertTrue(oneCentimeter.isEqual(tenMillimeters));
        assertFalse(fiveCentimeter.isEqual(fifteenMillimeters));
    }

    @Test
    void compareMillimeterAndInchForEquality() throws InvalidLengthException {
        Length hundredMillimeters = Length.create(100, LengthUnit.MM);
        Length fourInches = Length.create(4, LengthUnit.INCH);

        Length twoHundredMillimeters = Length.create(200, LengthUnit.MM);
        Length fiveInches = Length.create(5, LengthUnit.INCH);

        assertTrue(hundredMillimeters.isEqual(fourInches));
        assertFalse(twoHundredMillimeters.isEqual(fiveInches));
    }

    @Test
    void throwInvalidLengthException() {
        assertThrows(InvalidLengthException.class, () -> Length.create(-2, LengthUnit.FEET));
    }

    @Test
    void compareOneLengthGreaterThanOther() throws InvalidLengthException {
        Length hundredAndTenMillimeters = Length.create(110, LengthUnit.MM);
        Length fourInches = Length.create(4, LengthUnit.INCH);

        Length twentyInches = Length.create(20, LengthUnit.INCH);
        Length fiveFeet = Length.create(5, LengthUnit.FEET);

        assertTrue(hundredAndTenMillimeters.isGreaterThan(fourInches));
        assertFalse(twentyInches.isGreaterThan(fiveFeet));
    }

    @Test
    void compareEqualityOfTwoLengths() throws InvalidLengthException {
        Length oneCentimeter = Length.create(1, LengthUnit.CM);
        Length tenMillimeters = Length.create(10, LengthUnit.MM);

        assertEquals(ComparisonResult.EQUAL, oneCentimeter.compare(tenMillimeters));
    }

    @Test
    void compareIfOneLengthIsGreaterThanOther() throws InvalidLengthException {
        Length twoCentimeters = Length.create(2, LengthUnit.CM);
        Length tenMillimeters = Length.create(10, LengthUnit.MM);

        assertEquals(ComparisonResult.GREATER, twoCentimeters.compare(tenMillimeters));
    }

    @Test
    void compareIfOneLengthIsLesserThanOther() throws InvalidLengthException {
        Length fiveMillimeters = Length.create(5, LengthUnit.MM);
        Length oneCentimeter = Length.create(1, LengthUnit.CM);

        assertEquals(ComparisonResult.LESSER, fiveMillimeters.compare(oneCentimeter));
    }
}

package com.tw.step8.assignment3;

import com.tw.step8.assignment3.exception.NegativeMeasureException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthTest {
    @Test
    void createALength() throws NegativeMeasureException {
        Length inch1 = Length.create(5, LengthUnit.INCH);
        Length inch2 = Length.create(5, LengthUnit.INCH);

        assertEquals(inch1, inch2);
    }

    @Test
    void compareInchAndFootForEquality() throws NegativeMeasureException {
        Length twelveInches = Length.create(12, LengthUnit.INCH);
        Length oneFeet = Length.create(1, LengthUnit.FEET);

        Length fiveInches = Length.create(5, LengthUnit.INCH);
        Length threeFeet = Length.create(3, LengthUnit.FEET);

        assertTrue(twelveInches.isEqual(oneFeet));
        assertFalse(fiveInches.isEqual(threeFeet));
    }

    @Test
    void compareInchAndCentimeterForEquality() throws NegativeMeasureException {
        Length twoInches = Length.create(2, LengthUnit.INCH);
        Length fiveCentimeters = Length.create(5, LengthUnit.CM);

        Length oneInch = Length.create(1, LengthUnit.INCH);
        Length twoCentimeters = Length.create(2, LengthUnit.CM);

        assertTrue(twoInches.isEqual(fiveCentimeters));
        assertFalse(oneInch.isEqual(twoCentimeters));
    }

    @Test
    void compareCentimeterAndMillimeterForEquality() throws NegativeMeasureException {
        Length oneCentimeter = Length.create(1, LengthUnit.CM);
        Length tenMillimeters = Length.create(10, LengthUnit.MM);

        Length fiveCentimeter = Length.create(5, LengthUnit.CM);
        Length fifteenMillimeters = Length.create(15, LengthUnit.MM);

        assertTrue(oneCentimeter.isEqual(tenMillimeters));
        assertFalse(fiveCentimeter.isEqual(fifteenMillimeters));
    }

    @Test
    void compareMillimeterAndInchForEquality() throws NegativeMeasureException {
        Length hundredMillimeters = Length.create(100, LengthUnit.MM);
        Length fourInches = Length.create(4, LengthUnit.INCH);

        Length twoHundredMillimeters = Length.create(200, LengthUnit.MM);
        Length fiveInches = Length.create(5, LengthUnit.INCH);

        assertTrue(hundredMillimeters.isEqual(fourInches));
        assertFalse(twoHundredMillimeters.isEqual(fiveInches));
    }

    @Test
    void throwInvalidLengthException() {
        assertThrows(NegativeMeasureException.class, () -> Length.create(-2, LengthUnit.FEET));
    }

    @Test
    void compareOneLengthGreaterThanOther() throws NegativeMeasureException {
        Length hundredAndTenMillimeters = Length.create(110, LengthUnit.MM);
        Length fourInches = Length.create(4, LengthUnit.INCH);

        Length twentyInches = Length.create(20, LengthUnit.INCH);
        Length fiveFeet = Length.create(5, LengthUnit.FEET);

        assertTrue(hundredAndTenMillimeters.isGreaterThan(fourInches));
        assertFalse(twentyInches.isGreaterThan(fiveFeet));
    }

    @Test
    void compareEqualityOfTwoLengths() throws NegativeMeasureException {
        Length oneCentimeter = Length.create(1, LengthUnit.CM);
        Length tenMillimeters = Length.create(10, LengthUnit.MM);

        assertEquals(ComparisonResult.EQUAL, oneCentimeter.compare(tenMillimeters));
    }

    @Test
    void compareIfOneLengthIsGreaterThanOther() throws NegativeMeasureException {
        Length twoCentimeters = Length.create(2, LengthUnit.CM);
        Length tenMillimeters = Length.create(10, LengthUnit.MM);

        assertEquals(ComparisonResult.GREATER, twoCentimeters.compare(tenMillimeters));
    }

    @Test
    void compareIfOneLengthIsLesserThanOther() throws NegativeMeasureException {
        Length fiveMillimeters = Length.create(5, LengthUnit.MM);
        Length oneCentimeter = Length.create(1, LengthUnit.CM);

        assertEquals(ComparisonResult.LESSER, fiveMillimeters.compare(oneCentimeter));
    }

    @Test
    void addTwoLengthsOfInchUnit() throws NegativeMeasureException {
        Length twoInches = Length.create(2, LengthUnit.INCH);
        Length threeInches = Length.create(3, LengthUnit.INCH);

        Length expectedLength = Length.create(5, LengthUnit.INCH);

        assertEquals(expectedLength, twoInches.add(threeInches));
    }

    @Test
    void addTwoLengthsOfDifferentUnits() throws NegativeMeasureException {
        Length twoAndHalfCM = Length.create(2.5, LengthUnit.CM);
        Length twoInches = Length.create(2, LengthUnit.INCH);

        Length expectedLength = Length.create(3, LengthUnit.INCH);

        assertEquals(expectedLength, twoAndHalfCM.add(twoInches));
    }
}

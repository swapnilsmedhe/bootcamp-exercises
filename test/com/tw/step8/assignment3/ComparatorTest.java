package com.tw.step8.assignment3;

import com.tw.step8.assignment3.exception.InvalidLengthException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ComparatorTest {
    @Test
    void compareEqualityOfTwoLengths() throws InvalidLengthException {
        Length oneCentimeter = Length.create(1, Unit.CM);
        Length tenMillimeters = Length.create(10, Unit.MM);

        assertEquals(ComparisonResult.EQUAL, Comparator.compare(oneCentimeter, tenMillimeters));
    }

    @Test
    void compareIfOneLengthIsGreaterThanOther() throws InvalidLengthException {
        Length twoCentimeters = Length.create(2, Unit.CM);
        Length tenMillimeters = Length.create(10, Unit.MM);

        assertEquals(ComparisonResult.GREATER, Comparator.compare(twoCentimeters, tenMillimeters));
    }

    @Test
    void compareIfOneLengthIsLesserThanOther() throws InvalidLengthException {
        Length fiveMillimeters = Length.create(5, Unit.MM);
        Length oneCentimeter = Length.create(1, Unit.CM);

        assertEquals(ComparisonResult.LESSER, Comparator.compare(fiveMillimeters, oneCentimeter));
    }
}

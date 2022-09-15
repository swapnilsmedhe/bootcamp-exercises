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
    void areTwoLengthsEqual() {
        Length inch = new Length(12, Unit.INCH);
        Length feet = new Length(1, Unit.FEET);

        assertTrue(inch.isEqual(feet));
    }
}

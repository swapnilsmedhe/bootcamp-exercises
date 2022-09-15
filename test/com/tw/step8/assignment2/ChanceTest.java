package com.tw.step8.assignment2;

import com.tw.step8.assignment2.exception.InvalidProbabilityException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ChanceTest {
    @Test
    void throwExceptionOnInvalidProbability() {
        assertThrows(InvalidProbabilityException.class, () -> Chance.create(1.2));
    }

    @Test
    void notOfAChance() throws InvalidProbabilityException {
        Chance chanceOfHeads = Chance.create(0.25);
        Chance notOfHeads = chanceOfHeads.not();
        Chance expectedNotOfHeads = Chance.create(0.75);

        assertEquals(expectedNotOfHeads, notOfHeads);
    }

    @Test
    void andOfTwoChances() throws InvalidProbabilityException {
        Chance chanceOfHeads = Chance.create(1.0/2);
        Chance chanceOfRollingTwo = Chance.create(1.0/6);

        Chance expectedAndOfTwoChances = Chance.create(1.0/12);
        Chance actualAndOfTwoChances = chanceOfHeads.and(chanceOfRollingTwo);

        assertTrue(expectedAndOfTwoChances.isDifferenceLessThanDelta(actualAndOfTwoChances, 0.01));
    }

    @Test
    void orOfTwoChances() throws InvalidProbabilityException {
        Chance chanceOfHeads = Chance.create(1.0/4);
        Chance chanceOfRollingTwo = Chance.create(1.0/6);

        Chance expectedOrOfTwoChances = Chance.create(9.0 / 24);
        Chance actualOrOfTwoChances = chanceOfHeads.or(chanceOfRollingTwo);

        assertTrue(expectedOrOfTwoChances.isDifferenceLessThanDelta(actualOrOfTwoChances, 0.01));
    }

    @Test
    void isDifferenceLessThanDelta() throws InvalidProbabilityException {
        Chance chanceOfHeads = Chance.create(1.0/2);
        Chance chanceOfRollingTwo = Chance.create(1.0 / 6);

        assertTrue(chanceOfHeads.isDifferenceLessThanDelta(chanceOfRollingTwo, 0.4));
    }
}

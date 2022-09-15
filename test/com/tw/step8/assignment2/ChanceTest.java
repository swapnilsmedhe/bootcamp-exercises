package com.tw.step8.assignment2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChanceTest {
    @Test
    void throwExceptionOnInvalidProbability() {

        try{
            Chance.create(1.5);
        } catch (InvalidProbabilityException e) {
            assertEquals(e, new InvalidProbabilityException(1.5));
        }
    }

    @Test
    void createAChance() throws InvalidProbabilityException {
        Chance chance1 = Chance.create(0.25);
        Chance chance2 = Chance.create(0.25);

        assertEquals(chance1, chance2);
    }

    @Test
    void chanceOfNotGetting() throws InvalidProbabilityException {
        Chance chance = Chance.create(0.5);
        Chance complement = chance.not();
        Chance expectedComplement = Chance.create(0.5);

        assertEquals(expectedComplement, complement);
    }

    @Test
    void andOfTwoChances() throws InvalidProbabilityException {
        Chance chance1 = Chance.create(0.5);
        Chance chance2 = Chance.create(0.5);

        Chance expectedCombinedChance = Chance.create(0.25);

        assertEquals(expectedCombinedChance, chance1.and(chance2));
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

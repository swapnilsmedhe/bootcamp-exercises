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
        Chance noChanceOfHeads = Chance.createNoChance(0.5);

        Chance expectedNoChanceOfHeads = Chance.create(0.5);
        assertEquals(expectedNoChanceOfHeads, noChanceOfHeads);
    }
}
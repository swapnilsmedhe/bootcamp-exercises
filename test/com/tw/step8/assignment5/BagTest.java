package com.tw.step8.assignment5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BagTest {
    @Test
    void shouldStoreABall() {
        Bag bag = new Bag(1, Colour.GREEN, 1);
        Ball ball = new Ball(Colour.GREEN);

        Status actualStatus = bag.store(ball);

        assertEquals(Status.STORED, actualStatus);
    }

    @Test
    void shouldNotStoreABallIfCapacityReached() {
        Bag bag = new Bag(0, Colour.GREEN, 1);
        Ball ball = new Ball(Colour.GREEN);

        Status actualStatus = bag.store(ball);

        assertEquals(Status.MAX_CAPACITY_REACHED, actualStatus);
    }

    @Test
    void shouldNotStoreGreenBallsBeyondLimit() {
        Bag bag = new Bag(2, Colour.GREEN, 1);
        Ball firstGreenBall = new Ball(Colour.GREEN);
        Ball secondGreenBall = new Ball(Colour.GREEN);

        bag.store(firstGreenBall);
        Status actualStatus = bag.store(secondGreenBall);

        assertEquals(Status.MAX_COLOUR_BALLS_REACHED, actualStatus);
    }
}
package com.tw.step8.assignment5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BagTest {
    @Test
    void shouldStoreABall() {
        Bag bag = new Bag(1);
        Ball ball = new Ball();

        Status actualStatus = bag.store(ball);

        assertEquals(Status.STORED, actualStatus);
    }

    @Test
    void shouldNotStoreABallIfCapacityReached() {
        Bag bag = new Bag(0);
        Ball ball = new Ball();

        Status actualStatus = bag.store(ball);

        assertEquals(Status.MAX_CAPACITY_REACHED, actualStatus);
    }
}
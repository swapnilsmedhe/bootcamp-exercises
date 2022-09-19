package com.tw.step8.assignment5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BagTest {
    @Test
    void shouldStoreABall() {
        Bag bag = new Bag(1, Colour.GREEN, 1, Colour.RED);
        Ball ball = new Ball(Colour.GREEN);

        Status actualStatus = bag.store(ball);

        assertEquals(Status.STORED, actualStatus);
    }

    @Test
    void shouldNotStoreABallIfCapacityReached() {
        Bag bag = new Bag(0, Colour.GREEN, 1, Colour.RED);
        Ball ball = new Ball(Colour.GREEN);

        Status actualStatus = bag.store(ball);

        assertEquals(Status.MAX_CAPACITY_REACHED, actualStatus);
    }

    @Test
    void shouldNotStoreGreenBallsBeyondLimit() {
        Bag bag = new Bag(2, Colour.GREEN, 1, Colour.RED);
        Ball firstGreenBall = new Ball(Colour.GREEN);
        Ball secondGreenBall = new Ball(Colour.GREEN);

        bag.store(firstGreenBall);
        Status actualStatus = bag.store(secondGreenBall);

        assertEquals(Status.MAX_COLOUR_BALLS_REACHED, actualStatus);
    }

    @Test
    void shouldNotStoreRedBallsIfTheyAreDoubleGreenBalls() {
        Bag bag = new Bag(4, Colour.GREEN, 2, Colour.RED);
        Ball greenBall = new Ball(Colour.GREEN);
        Ball firstRedBall = new Ball(Colour.RED);
        Ball secondRedBall = new Ball(Colour.RED);
        Ball thirdRedBall = new Ball(Colour.RED);

        bag.store(greenBall);
        bag.store(firstRedBall);
        bag.store(secondRedBall);
        Status actualStatus = bag.store(thirdRedBall);

        assertEquals(Status.MAX_COLOUR_BALLS_REACHED, actualStatus);
    }

    @Test
    void shouldNotStoreYellowBallIfItsOccupancyIsMoreThanFortyPercent() {
        Bag bag = new Bag(3, Colour.GREEN, 2, Colour.RED);
        Ball greenBall = new Ball(Colour.GREEN);
        Ball yellowBall = new Ball(Colour.YELLOW);

        bag.store(greenBall);
        Status actualStatus = bag.store(yellowBall);

        assertEquals(Status.MAX_COLOUR_BALLS_REACHED, actualStatus);
    }

    @Test
    void shouldStoreYellowBall() {
        Bag bag = new Bag(3, Colour.GREEN, 2, Colour.RED);
        Ball greenBall = new Ball(Colour.GREEN);
        Ball redBall = new Ball(Colour.RED);
        Ball yellowBall = new Ball(Colour.YELLOW);

        bag.store(greenBall);
        bag.store(redBall);
        Status actualStatus = bag.store(yellowBall);

        assertEquals(Status.STORED, actualStatus);
    }
}
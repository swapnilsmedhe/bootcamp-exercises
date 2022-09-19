package com.tw.step8.assignment5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BagTest {
    @Test
    void shouldStoreABall() throws NegativeCapacityException {
        Bag bag = Bag.createBag(1,1);
        Ball ball = new Ball(Colour.GREEN);

        Status actualStatus = bag.store(ball);

        assertEquals(Status.STORED, actualStatus);
    }

    @Test
    void shouldThrowExceptionWhenNegativeCapacityIsGiven() {
        assertThrows(NegativeCapacityException.class, ()->Bag.createBag(-1, 1));
        assertThrows(NegativeCapacityException.class, ()->Bag.createBag(1, -1));
    }

    @Test
    void shouldNotStoreABallIfCapacityReached() throws NegativeCapacityException {
        Bag bag = Bag.createBag(0, 1);
        Ball ball = new Ball(Colour.GREEN);

        Status actualStatus = bag.store(ball);

        assertEquals(Status.MAX_CAPACITY_REACHED, actualStatus);
    }

    @Test
    void shouldNotStoreGreenBallsBeyondLimit() throws NegativeCapacityException {
        Bag bag = Bag.createBag(2, 1);
        Ball firstGreenBall = new Ball(Colour.GREEN);
        Ball secondGreenBall = new Ball(Colour.GREEN);

        bag.store(firstGreenBall);
        Status actualStatus = bag.store(secondGreenBall);

        assertEquals(Status.MAX_COLOUR_BALLS_REACHED, actualStatus);
    }

    @Test
    void shouldNotStoreRedBallsIfTheyAreDoubleTheSizeOfGreenBalls() throws NegativeCapacityException {
        Bag bag = Bag.createBag(4, 2);
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
    void shouldNotStoreYellowBallIfItsOccupancyIsMoreThanFortyPercent() throws NegativeCapacityException {
        Bag bag = Bag.createBag(3, 2);
        Ball greenBall = new Ball(Colour.GREEN);
        Ball yellowBall = new Ball(Colour.YELLOW);

        bag.store(greenBall);
        Status actualStatus = bag.store(yellowBall);

        assertEquals(Status.MAX_COLOUR_BALLS_REACHED, actualStatus);
    }

    @Test
    void shouldStoreYellowBall() throws NegativeCapacityException {
        Bag bag = Bag.createBag(3, 2);
        Ball greenBall = new Ball(Colour.GREEN);
        Ball redBall = new Ball(Colour.RED);
        Ball yellowBall = new Ball(Colour.YELLOW);

        bag.store(greenBall);
        bag.store(redBall);
        Status actualStatus = bag.store(yellowBall);

        assertEquals(Status.STORED, actualStatus);
    }

    @Test
    void shouldNotStoreBlackBallIfBlueBallIsPresent() throws NegativeCapacityException {
        Bag bag = Bag.createBag(3, 2);
        Ball blueBall = new Ball(Colour.BLUE);
        Ball blackBall = new Ball(Colour.BLACK);

        bag.store(blueBall);
        Status actualStatus = bag.store(blackBall);

        assertEquals(Status.CANNOT_STORE, actualStatus);
    }

    @Test
    void shouldNotStoreBlueBallIfBlackBallIsPresent() throws NegativeCapacityException {
        Bag bag = Bag.createBag(3, 2);
        Ball blackBall = new Ball(Colour.BLACK);
        Ball blueBall = new Ball(Colour.BLUE);

        bag.store(blackBall);
        Status actualStatus = bag.store(blueBall);

        assertEquals(Status.CANNOT_STORE, actualStatus);
    }
}
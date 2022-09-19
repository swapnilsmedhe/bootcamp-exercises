package com.tw.step8.assignment5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BallTest {
    @Test
    void shouldTellIfBallIsOfSpecificColour() {
        Ball greenBall = new Ball(Colour.GREEN);
        Ball redBall = new Ball(Colour.RED);

        assertTrue(greenBall.isOf(Colour.GREEN));
        assertFalse(redBall.isOf(Colour.GREEN));
    }
}
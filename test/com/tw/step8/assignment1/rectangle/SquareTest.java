package com.tw.step8.assignment1.rectangle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {
    @Test
    void areaOfSquare() {
        Square square = new Square(5);

        assertEquals(25, square.area());
    }

    @Test
    void perimeterOfSquare() {
        Square square = new Square(2);

        assertEquals(8, square.perimeter());
    }
}

package com.tw.step8.assignment1.rectangle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {
    @Test
    void areaOfRectangle() {
        Rectangle rectangle = new Rectangle(5, 10);

        assertEquals(50, rectangle.area());
    }

    @Test
    void perimeterOfRectangle() {
        Rectangle rectangle = new Rectangle(2, 3);

        assertEquals(10, rectangle.perimeter());
    }
}

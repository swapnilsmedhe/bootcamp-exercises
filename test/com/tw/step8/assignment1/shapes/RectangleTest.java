package com.tw.step8.assignment1.shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {
    @Test
    void area() {
        Rectangle rectangle = Rectangle.createRectangle(5, 10);
        Rectangle square = Rectangle.createSquare(4);

        assertEquals(50, rectangle.area());
        assertEquals(16, square.area());
    }

    @Test
    void perimeter() {
        Rectangle rectangle = Rectangle.createRectangle(2, 3);
        Rectangle square = Rectangle.createSquare(8);

        assertEquals(10, rectangle.perimeter());
        assertEquals(32, square.perimeter());
    }
}

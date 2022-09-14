package com.tw.step8.assignment1.shapes;

public class Rectangle {
    private final double length;
    private final double breadth;

    private Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public static Rectangle createRectangle(double length, double breadth) {
        return new Rectangle(length, breadth);
    }

    public static Rectangle createSquare(double side) {
        return Rectangle.createRectangle(side, side);
    }

    public double area() {
        return length * breadth;
    }

    public double perimeter() {
        return 2 * (length + breadth);
    }
}

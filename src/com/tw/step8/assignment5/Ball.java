package com.tw.step8.assignment5;

public class Ball {

    private Colour colour;

    public Ball(Colour colour) {
        this.colour = colour;
    }

    public boolean isOf(Colour colour) {
        return this.colour == colour;
    }
}

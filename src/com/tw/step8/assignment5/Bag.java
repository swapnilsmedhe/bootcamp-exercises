package com.tw.step8.assignment5;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Bag {
    private final int capacity;
    private final HashSet<Ball> balls;
    private final Colour colour;
    private final int colourBallsLimit;

    public Bag(int capacity, Colour colour, int colourBallsLimit) {
        this.capacity = capacity;
        this.balls = new HashSet<>(capacity);
        this.colour = colour;
        this.colourBallsLimit = colourBallsLimit;
    }


    public Status store(Ball ball) {
        if (balls.size() >= capacity) {
            return Status.MAX_CAPACITY_REACHED;
        }

        List<Ball> colouredBalls = getBalls(colour);

        if (colouredBalls.size() >= colourBallsLimit){
            return Status.MAX_COLOUR_BALLS_REACHED;
        }

        balls.add(ball);
        return Status.STORED;
    }

    private List<Ball> getBalls(Colour colour) {
        return balls.stream()
                .filter(ball -> ball.ifOf(colour))
                .collect(Collectors.toList());
    }
}

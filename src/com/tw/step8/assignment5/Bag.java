package com.tw.step8.assignment5;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Bag {
    private final int capacity;
    private final HashSet<Ball> balls;
    private final Colour colour;
    private final int colourBallsLimit;
    private Colour dependantColour;

    public Bag(int capacity, Colour colour, int colourBallsLimit, Colour dependantColour) {
        this.capacity = capacity;
        this.balls = new HashSet<>();
        this.colour = colour;
        this.colourBallsLimit = colourBallsLimit;
        this.dependantColour = dependantColour;
    }


    public Status store(Ball ball) {
        if (balls.size() >= capacity) {
            return Status.MAX_CAPACITY_REACHED;
        }

        if (canAddDependantColourBall(ball)){
            return Status.MAX_COLOUR_BALLS_REACHED;
        }

        List<Ball> colouredBalls = getBalls(colour);

        if (colouredBalls.size() >= colourBallsLimit){
            return Status.MAX_COLOUR_BALLS_REACHED;
        }

        if(ball.isOf(Colour.YELLOW) && !canAddYellowBalls()){
            return Status.MAX_COLOUR_BALLS_REACHED;
        }

        balls.add(ball);
        return Status.STORED;
    }

    private boolean canAddYellowBalls() {
        List<Ball> yellowBalls = getBalls(Colour.YELLOW);
        int yellowBallsCount = yellowBalls.size();
        int yellowBallOccupancy =  (yellowBallsCount + 1) * 100 / (balls.size() + 1);
        return yellowBallOccupancy <= 40;
    }

    private boolean canAddDependantColourBall(Ball ball) {
        List<Ball> colouredBalls = getBalls(colour);
        List<Ball> dependantColouredBalls = getBalls(dependantColour);

        return (2 * colouredBalls.size()) <= dependantColouredBalls.size() && ball.isOf(dependantColour);
    }

    private List<Ball> getBalls(Colour colour) {
        return balls.stream()
                .filter(ball -> ball.isOf(colour))
                .collect(Collectors.toList());
    }
}

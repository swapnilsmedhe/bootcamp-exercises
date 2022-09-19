package com.tw.step8.assignment5;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Bag {
    private final int capacity;
    private final HashSet<Ball> balls;
    private final int greenBallsLimit;

    public Bag(int capacity, int greenBallsLimit) {
        this.capacity = capacity;
        this.balls = new HashSet<>();
        this.greenBallsLimit = greenBallsLimit;
    }


    public Status store(Ball ball) {
        if (balls.size() >= capacity) {
            return Status.MAX_CAPACITY_REACHED;
        }

        if (ball.isOf(Colour.RED) && !canAddRedBall()){
            return Status.MAX_COLOUR_BALLS_REACHED;
        }

        if (ball.isOf(Colour.GREEN) && !canAddGreenBall()){
            return Status.MAX_COLOUR_BALLS_REACHED;
        }

        if(ball.isOf(Colour.YELLOW) && !canAddYellowBall()){
            return Status.MAX_COLOUR_BALLS_REACHED;
        }

        balls.add(ball);
        return Status.STORED;
    }

    private boolean canAddGreenBall() {
        List<Ball> greenBalls = getBalls(Colour.GREEN);
        return greenBalls.size() < greenBallsLimit;
    }

    private boolean canAddYellowBall() {
        List<Ball> yellowBalls = getBalls(Colour.YELLOW);
        int yellowBallsCount = yellowBalls.size();
        int yellowBallOccupancy =  (yellowBallsCount + 1) * 100 / (balls.size() + 1);
        return yellowBallOccupancy <= 40;
    }

    private boolean canAddRedBall() {
        List<Ball> greenBalls = getBalls(Colour.GREEN);
        List<Ball> redBalls = getBalls(Colour.RED);

        return redBalls.size() < (2 * greenBalls.size());
    }

    private List<Ball> getBalls(Colour colour) {
        return balls.stream()
                .filter(ball -> ball.isOf(colour))
                .collect(Collectors.toList());
    }
}

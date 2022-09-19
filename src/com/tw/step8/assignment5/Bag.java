package com.tw.step8.assignment5;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Bag {
    private final int capacity;
    private final HashSet<Ball> balls;

    public Bag(int capacity) {
        this.capacity = capacity;
        this.balls = new HashSet<>(capacity);
    }


    public Status store(Ball ball) {
        if (balls.size() < capacity){
            balls.add(ball);
            return Status.STORED;
        }
        return Status.MAX_CAPACITY_REACHED;
    }
}

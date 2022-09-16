package com.tw.step8.assignment4.exception;

public class ParkingLotFullException extends Throwable {
    private Integer capacity;

    public ParkingLotFullException(Integer capacity) {
        this.capacity = capacity;
    }

    @Override
    public String getMessage() {
        return String.format("Can not park, all %d slots are full", capacity);
    }
}

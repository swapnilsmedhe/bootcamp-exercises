package com.tw.step8.assignment4.exception;

public class AllParkingLotsFullException extends Throwable {
    private int parkingLots;

    public AllParkingLotsFullException(int parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
    public String getMessage() {
        return String.format("Can not be parked, %d parking lots are full", parkingLots);
    }
}

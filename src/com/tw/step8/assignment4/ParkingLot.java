package com.tw.step8.assignment4;

import java.util.ArrayList;

public class ParkingLot {
    private Integer capacity;
    private ArrayList<Car> parkingSlots;

    public ParkingLot(Integer capacity) {
        this.capacity = capacity;
        this.parkingSlots = new ArrayList<Car>(capacity);
    }


    public  Integer park(Car car) {
        parkingSlots.add(car);
        return parkingSlots.size();
    }
}

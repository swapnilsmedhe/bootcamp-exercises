package com.tw.step8.assignment4;

import com.tw.step8.assignment4.exception.ParkingLotFullException;

import java.util.ArrayList;

public class ParkingLot {
    private Integer capacity;
    private ArrayList<Car> parkingSlots;

    public ParkingLot(Integer capacity) {
        this.capacity = capacity;
        this.parkingSlots = new ArrayList<Car>(capacity);
    }


    public  Integer park(Car car) throws ParkingLotFullException {
        if (this.isFull()){
            throw new ParkingLotFullException(capacity);
        }
        parkingSlots.add(car);
        return parkingSlots.size();
    }

    public boolean isFull() {
        return capacity == parkingSlots.size();
    }
}

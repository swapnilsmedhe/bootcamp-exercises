package com.tw.step8.assignment4.parking;

import com.tw.step8.assignment4.Car;
import com.tw.step8.assignment4.exception.ParkingLotFullException;

import java.util.ArrayList;


public class ParkingLot {
    private final Integer capacity;
    private final ArrayList<Car> parkingSlots;
    private final Notifier notifier;

    public ParkingLot(Integer id, Integer capacity, Notifier notifier) {
        this.capacity = capacity;
        this.parkingSlots = new ArrayList<Car>(capacity);
        this.notifier = notifier;
    }

    public  Integer park(Car car) throws ParkingLotFullException {
        if (this.isFull()){
            throw new ParkingLotFullException(capacity);
        }

        parkingSlots.add(car);

        this.notifyOnFull();
        return parkingSlots.size();
    }

    private void notifyOnFull() {
        if (this.isFull()) {
            notifier.notify(Notification.LOT_FULL);
        }
    }

    public boolean isFull() {
        return capacity == parkingSlots.size();
    }
}


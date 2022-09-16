package com.tw.step8.assignment4.parking;

import com.tw.step8.assignment4.Car;
import com.tw.step8.assignment4.exception.AllParkingLotsFullException;
import com.tw.step8.assignment4.exception.ParkingLotFullException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Attendant implements Notifiable{
    private ArrayList<ParkingLot> parkingLots;

    public Attendant() {
        parkingLots = new ArrayList<ParkingLot>();
    }

    @Override
    public void receiveNotification(Notification notification) {

    }

    public void attend(ParkingLot parkingLot) {
        parkingLots.add(parkingLot);
    }

    public ParkingReceipt park(Car car) throws ParkingLotFullException, AllParkingLotsFullException {
        List<ParkingLot> vacantParkingLots = this.getVacantParkingLots();
        
        if (vacantParkingLots.size() == 0) {
            throw new AllParkingLotsFullException(parkingLots.size());
        }

        ParkingLot vacantParkingLot = vacantParkingLots.get(0);
        Integer slotNumber = vacantParkingLot.park(car);

        return new ParkingReceipt(vacantParkingLot.getId(), slotNumber);
    }

    private List<ParkingLot> getVacantParkingLots() {
        return parkingLots.stream()
                .filter(parkingLot -> !parkingLot.isFull())
                .collect(Collectors.toList());
    }
}

package com.tw.step8.assignment4.parking;

import java.util.Objects;

public class ParkingReceipt {
    private final int parkingLotNumber;
    private final int slotNumber;

    public ParkingReceipt(int parkingLotNumber, int slotNumber) {
        this.parkingLotNumber = parkingLotNumber;
        this.slotNumber = slotNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingReceipt that = (ParkingReceipt) o;
        return parkingLotNumber == that.parkingLotNumber && slotNumber == that.slotNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(parkingLotNumber, slotNumber);
    }
}

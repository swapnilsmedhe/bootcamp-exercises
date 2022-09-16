package com.tw.step8.assignment4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {
    @Test
    void shouldParkACar() {
        ParkingLot parkingLot = new ParkingLot(5);
        Car car = new Car("MH-123");
 
        Integer slot = parkingLot.park(car);
        assertEquals(1, slot);
    }

    @Test
    void shouldTellIfParkingLotIsFull() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car("MH-15");

        parkingLot.park(car);

        assertTrue(parkingLot.isFull());
    }

    @Test
    void shouldTellWhenParkingLotIsNotFull() {
        ParkingLot parkingLot = new ParkingLot(1);

        assertFalse(parkingLot.isFull());
    }
}
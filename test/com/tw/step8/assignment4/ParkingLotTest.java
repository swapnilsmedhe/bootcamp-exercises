package com.tw.step8.assignment4;

import com.tw.step8.assignment4.exception.ParkingLotFullException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {
    @Test
    void shouldParkACar() throws ParkingLotFullException {
        ParkingLot parkingLot = new ParkingLot(5);
        Car car = new Car("MH-123");
 
        Integer slot = parkingLot.park(car);
        assertEquals(1, slot);
    }

    @Test
    void shouldTellIfParkingLotIsFull() throws ParkingLotFullException {
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

    @Test
    void shouldThrowExceptionOnAttemptOfParkingWhenParkingLotIsFull() throws ParkingLotFullException {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car("MH-15");

        parkingLot.park(car);

        assertThrows(ParkingLotFullException.class, () -> parkingLot.park(car));
    }
}
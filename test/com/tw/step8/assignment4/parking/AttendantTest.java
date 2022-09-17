package com.tw.step8.assignment4.parking;

import com.tw.step8.assignment4.Car;
import com.tw.step8.assignment4.exception.AllParkingLotsFullException;
import com.tw.step8.assignment4.exception.ParkingLotFullException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AttendantTest {
    @Test
    void shouldParkACarInGivenParkingLot() throws ParkingLotFullException, AllParkingLotsFullException {
        ParkingLot parkingLot = new ParkingLot(1, 1, new Notifier());
        Attendant attendant = new Attendant();

        attendant.attend(parkingLot);

        ParkingReceipt expectedReceipt = new ParkingReceipt(1, 1);
        ParkingReceipt actualReceipt = attendant.park(new Car("MH-9"));

        assertEquals(expectedReceipt, actualReceipt);
    }

    @Test
    void shouldThrowExceptionWhenAllParkingLotsAreFull() {
        ParkingLot parkingLot = new ParkingLot(1, 0, new Notifier());
        Attendant attendant = new Attendant();

        attendant.attend(parkingLot);

        assertThrows(AllParkingLotsFullException.class, () -> attendant.park(new Car("MH-3")));
    }
}

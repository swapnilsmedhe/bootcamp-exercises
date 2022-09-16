package com.tw.step8.assignment4.parking;

import com.tw.step8.assignment4.Car;
import com.tw.step8.assignment4.exception.AllParkingLotsFullException;
import com.tw.step8.assignment4.exception.ParkingLotFullException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

class AttendantTest {
    @Test
    void shouldParkACarInGivenParkingLot() throws ParkingLotFullException, AllParkingLotsFullException {
        Attendant attendant = new Attendant();

        ArrayList<Notifiable> notifiables = new ArrayList<>();
        notifiables.add(attendant);

        ParkingLot parkingLot = new ParkingLot(1, 1, new Notifier(notifiables));
        attendant.attend(parkingLot);

        ParkingReceipt actualReceipt = attendant.park(new Car("MH-9"));
        ParkingReceipt expectedReceipt = new ParkingReceipt(1, 1);

        assertEquals(expectedReceipt, actualReceipt);
    }

    @Test
    void shouldThrowExceptionWhenAllParkingLotsAreFull() {
        Attendant attendant = new Attendant();

        ArrayList<Notifiable> notifiables = new ArrayList<>();
        notifiables.add(attendant);

        ParkingLot parkingLot = new ParkingLot(1, 0, new Notifier(notifiables));
        attendant.attend(parkingLot);

        assertThrows(AllParkingLotsFullException.class, () -> attendant.park(new Car("MH-3")));
    }
}
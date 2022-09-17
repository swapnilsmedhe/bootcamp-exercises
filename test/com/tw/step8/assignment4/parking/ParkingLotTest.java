package com.tw.step8.assignment4.parking;

import com.tw.step8.assignment4.Car;
import com.tw.step8.assignment4.exception.ParkingLotFullException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {
    @Test
    void shouldParkACar() throws ParkingLotFullException {
        ParkingLot parkingLot = new ParkingLot(1, 5, null);
        Car car = new Car("MH-123");

        Integer slot = parkingLot.park(car);
        assertEquals(1, slot);
    }

    @Test
    void shouldTellIfParkingLotIsFull() throws ParkingLotFullException {
        Notifiable notifiable = notification -> {
        };

        ArrayList<Notifiable> notifiables = new ArrayList<>();
        notifiables.add(notifiable);

        Notifier notifier = new Notifier();

        ParkingLot parkingLot = new ParkingLot(1, 1, notifier);
        Car car = new Car("MH-15");

        parkingLot.park(car);

        assertTrue(parkingLot.isFull());
    }

    @Test
    void shouldTellWhenParkingLotIsNotFull() {
        ParkingLot parkingLot = new ParkingLot(1, 1, null);

        assertFalse(parkingLot.isFull());
    }

    @Test
    void shouldThrowExceptionOnAttemptOfParkingWhenParkingLotIsFull() throws ParkingLotFullException {
        Notifiable notifiable = notification -> {
        };

        ArrayList<Notifiable> notifiables = new ArrayList<>();
        notifiables.add(notifiable);
        Notifier notifier = new Notifier();


        ParkingLot parkingLot = new ParkingLot(1, 1, notifier);
        Car car = new Car("MH-15");

        parkingLot.park(car);

        assertThrows(ParkingLotFullException.class, () -> parkingLot.park(car));
    }

    @Test
    void shouldNotifyWhenParkingLotIsFull() throws ParkingLotFullException {
        Notification[] recordedNotification = new Notification[1];

        Notifiable notifiable = notification -> {
            if (notification == Notification.LOT_FULL) {
                recordedNotification[0] = notification;
            }
        };

        Notifier notifier = new Notifier();
        notifier.addSubscriber(notifiable);

        ParkingLot parkingLot = new ParkingLot(1, 1, notifier);
        parkingLot.park(new Car("MH-15"));

        assertEquals(Notification.LOT_FULL, recordedNotification[0]);
    }
}

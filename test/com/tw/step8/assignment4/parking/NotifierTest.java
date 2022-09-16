package com.tw.step8.assignment4.parking;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NotifierTest {

    @Test
    void shouldNotifyToNotifiables() {
        Notification[] recordedNotification = new Notification[1];


        Notifiable notifiable = notification -> {
            if (notification == Notification.LOT_FULL) {
                recordedNotification[0] = notification;
            }
        };

        ArrayList<Notifiable> notifiables = new ArrayList<>();
        notifiables.add(notifiable);

        Notifier notifier = new Notifier(notifiables);
        notifier.notify(Notification.LOT_FULL);

        assertEquals(Notification.LOT_FULL, recordedNotification[0]);
    }
}
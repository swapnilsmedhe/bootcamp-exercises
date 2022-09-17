package com.tw.step8.assignment4.parking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotifierTest {

    @Test
    void shouldNotifyToNotifiables() {
        Notification[] recordedNotification = new Notification[1];
        Notifiable notifiable = (notification) -> recordedNotification[0] = notification;

        Notifier notifier = new Notifier();
        notifier.addSubscriber(notifiable);

        notifier.notify(Notification.LOT_FULL);

        assertEquals(Notification.LOT_FULL, recordedNotification[0]);
    }
}
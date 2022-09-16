package com.tw.step8.assignment4.parking;

public class Notifier {
    private Notifiable notifiable;

    public Notifier(Notifiable notifiable) {
        this.notifiable = notifiable;
    }

    void notify(Notification notification) {
        this.notifiable.receiveNotification(notification);
    }
}

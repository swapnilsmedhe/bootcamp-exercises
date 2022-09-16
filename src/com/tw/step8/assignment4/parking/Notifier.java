package com.tw.step8.assignment4.parking;

import java.util.ArrayList;

public class Notifier {
    private ArrayList<Notifiable> notifiables;

    public Notifier(ArrayList<Notifiable> notifiables) {
        this.notifiables = notifiables;
    }

    void notify(Notification notification) {
        for (Notifiable notifiable : notifiables) {
            notifiable.receiveNotification(notification);
        }
    }
}

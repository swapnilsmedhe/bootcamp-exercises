package com.tw.step8.assignment4.parking;

import java.util.ArrayList;

public class Notifier {
    private final ArrayList<Notifiable> subscribers;

    public Notifier() {
        this.subscribers = new ArrayList<>();
    }

    void notify(Notification notification) {
        for (Notifiable notifiable : subscribers) {
            notifiable.receiveNotification(notification);
        }
    }

    public void addSubscriber(Notifiable subscriber) {
        this.subscribers.add(subscriber);
    }
}

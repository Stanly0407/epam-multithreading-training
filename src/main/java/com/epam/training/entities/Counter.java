package com.epam.training.entities;

public class Counter {

    private int count;

    public Counter() {
    }

    public synchronized void increment() {
        this.count = count + 1;
    }

    public synchronized int getCount() {
        return count;
    }

}

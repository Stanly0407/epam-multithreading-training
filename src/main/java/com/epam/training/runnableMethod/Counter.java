package com.epam.training.runnableMethod;

public class Counter {

    private int count;

    public Counter(int count) {
        this.count = count;
    }

    public synchronized void increment() {
        this.count = count + 1;
    }

    public int getCount() {
        return count;
    }

}

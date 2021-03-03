package com.epam.training;

import com.epam.training.entities.Counter;

import java.util.stream.IntStream;


public class CounterRunnable implements Runnable {

    private static final int INCREMENTS = 10;

    private Counter counter;

    public CounterRunnable(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        IntStream.range(0, INCREMENTS).forEach(number -> counter.increment());
    }

}

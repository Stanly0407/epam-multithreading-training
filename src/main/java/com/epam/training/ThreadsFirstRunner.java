package com.epam.training;

import com.epam.training.entities.Counter;

import java.util.ArrayList;
import java.util.List;

public class ThreadsFirstRunner {

    private static final int NUMBER_OF_THREADS = 50;

    public static void main(String[] args) {

        List<Thread> threads = new ArrayList<>();
        Counter counter = new Counter();

        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            CounterRunnable counterRunnable = new CounterRunnable(counter);
            Thread thread = new Thread(counterRunnable);
            thread.start();
            threads.add(thread);
        }

//        for(Thread t : threads){
//            thread.join();}
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(counter.getCount());

    }
}

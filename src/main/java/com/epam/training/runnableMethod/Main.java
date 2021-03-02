package com.epam.training.runnableMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Counter counter = new Counter(0);

        ExecutorService executor = Executors.newFixedThreadPool(10);

        List<Future<?>> futures = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Runnable runnable = new CounterRunnable(counter);
            Future<?> future = executor.submit(runnable);
            futures.add(future);
        }

        for(Future<?> future : futures){
            future.get();
        }

        executor.shutdown();

        System.out.println(counter.getCount());



    }
}

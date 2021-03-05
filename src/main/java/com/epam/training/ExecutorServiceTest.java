package com.epam.training;

import com.epam.training.entities.Counter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceTest {

    private static final int NUMBER_OF_THREADS = 50;

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Counter counter = new Counter();

        ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

        List<Future<?>> futures = new ArrayList<>();

        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            Runnable runnable = new CounterRunnable(counter);
            Future<?> future = executor.submit(runnable);
            futures.add(future);

         //   CompletableFuture<?> completableFuture = CompletableFuture.runAsync(runnable, executor); //100
        }

        for (Future<?> future : futures) {
            future.get();
        }

        System.out.println(counter.getCount());

        executor.shutdown();

    }
}

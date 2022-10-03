package org.example.task_2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void performFizzBuzz(int n) {
        BlockingQueue<Integer> input = new LinkedBlockingQueue<>();
        BlockingQueue<String> output = new LinkedBlockingQueue<>();

        for(int i = 1; i <= n; i++) {
            input.add(i);
        }

        ExecutorService executor = Executors.newFixedThreadPool(5);

        executor.submit(new FizzThread(input, output));
        executor.submit(new BuzzThread(input, output));
        executor.submit(new FizzBuzzThread(input, output));
        executor.submit(new NumberThread(input, output));
        executor.submit(new PrinterThread(input, output));
    }

    public static void main(String[] args) {
        performFizzBuzz(15);
    }
}

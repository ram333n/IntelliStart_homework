package org.example;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Stopwatch {
    public static void main(String[] args) {
        int seconds = 0;

        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5_000);
                    System.out.println("Passed 5 seconds");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thread.start();

        while (true) {
            try {
                Thread.sleep(1_000);
                System.out.printf("Passed %d seconds from program start%n", ++seconds);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
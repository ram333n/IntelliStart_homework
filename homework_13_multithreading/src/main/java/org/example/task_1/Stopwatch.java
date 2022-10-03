package org.example.task_1;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Stopwatch {
    private static int seconds = 0;

    private static void passSecond() {
        System.out.printf("Passed %d seconds from program start%n", ++seconds);
    }

    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

        scheduler.scheduleWithFixedDelay(
                Stopwatch::passSecond,
                1,
                1,
                TimeUnit.SECONDS);

        scheduler.scheduleWithFixedDelay(
                () -> System.out.println("Passed 5 seconds"),
                5,
                5,
                TimeUnit.SECONDS);
    }
}
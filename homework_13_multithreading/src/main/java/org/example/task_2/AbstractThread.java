package org.example.task_2;

import java.util.concurrent.BlockingQueue;

public abstract class AbstractThread implements Runnable {
    protected final BlockingQueue<Integer> input;
    protected final BlockingQueue<String> output;

    protected AbstractThread(BlockingQueue<Integer> input, BlockingQueue<String> output) {
        this.input = input;
        this.output = output;
    }
}
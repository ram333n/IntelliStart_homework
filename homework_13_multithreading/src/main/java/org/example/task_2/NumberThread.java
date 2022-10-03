package org.example.task_2;

import java.util.concurrent.BlockingQueue;

public class NumberThread extends AbstractThread {
    public NumberThread(BlockingQueue<Integer> input, BlockingQueue<String> output) {
        super(input, output);
    }

    @Override
    public void run() {
        while(!input.isEmpty()) {
            int currentNumber = input.peek();
            if (currentNumber % 3 != 0 && currentNumber % 5 != 0) {
                try {
                    input.take();
                    output.put(Integer.toString(currentNumber));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

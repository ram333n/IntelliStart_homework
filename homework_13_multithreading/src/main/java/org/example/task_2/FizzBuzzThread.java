package org.example.task_2;

import java.util.concurrent.BlockingQueue;

public class FizzBuzzThread extends AbstractThread {
    public FizzBuzzThread(BlockingQueue<Integer> input, BlockingQueue<String> output) {
        super(input, output);
    }

    @Override
    public void run() {
        while(!input.isEmpty()) {
            int currentNumber = input.peek();
            if (checkFizzBuzz(currentNumber)) {
                try {
                    input.take();
                    output.put("fizzbuzz");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private boolean checkFizzBuzz(int num) {
        return num % 15 == 0;
    }
}

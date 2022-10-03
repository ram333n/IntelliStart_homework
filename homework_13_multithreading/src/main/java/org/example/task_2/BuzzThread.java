package org.example.task_2;

import java.util.concurrent.BlockingQueue;

public class BuzzThread extends AbstractThread {
    public BuzzThread(BlockingQueue<Integer> input, BlockingQueue<String> output) {
        super(input, output);
    }

    @Override
    public void run() {
        while(!input.isEmpty()) {
            int currentNumber = input.peek();
            if (checkBuzz(currentNumber)) {
                try {
                    input.take();
                    output.put("buzz");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private boolean checkBuzz(int num) {
        return num % 3 != 0 && num % 5 == 0;
    }
}

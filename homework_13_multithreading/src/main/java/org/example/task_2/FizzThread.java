package org.example.task_2;

import java.util.concurrent.BlockingQueue;

public class FizzThread extends AbstractThread {
    public FizzThread(BlockingQueue<Integer> input, BlockingQueue<String> output) {
        super(input, output);
    }

    @Override
    public void run() {
        while(!input.isEmpty()) {
            int currentNumber = input.peek();
            if (checkFizz(currentNumber)) {
                try {
                    input.take();
                    output.put("fizz");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private boolean checkFizz(int num) {
        return num % 3 == 0 && num % 5 != 0;
    }
}

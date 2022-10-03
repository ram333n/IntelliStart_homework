package org.example.task_2;

import java.util.concurrent.BlockingQueue;

public class PrinterThread extends AbstractThread {
    public PrinterThread(BlockingQueue<Integer>input, BlockingQueue<String> output) {
        super(input, output);
    }

    @Override
    public void run() {
        while(!input.isEmpty() || !output.isEmpty()) {
            String toPrint = null;
            try {
                toPrint = output.take();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.print(toPrint);

            if(!input.isEmpty() || !output.isEmpty()) {
                System.out.print(", ");
            }
        }
    }
}

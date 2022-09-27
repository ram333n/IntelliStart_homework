package org.example.queue;

import org.example.queue.exceptions.EmptyMyQueueException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyQueueTest {
    @Test
    void testQueue() throws EmptyMyQueueException {
        System.out.println("Queue : ");
        MyQueue<Integer> queue = new MyQueue<>();

        assertEquals(0, queue.size());

        queue.add(1);
        assertEquals(1, queue.poll()); //check corner case
        assertEquals(0, queue.size());

        System.out.println(queue);
        for(int i = 0; i < 5; i++) {
            queue.add(i);
        }
        System.out.println(queue);

        assertEquals(0, queue.peek());
        assertEquals(5, queue.size());

        assertEquals(0, queue.poll());
        assertEquals(1, queue.poll());
        assertEquals(3, queue.size());

        System.out.println(queue);

        queue.clear();
        assertEquals(0, queue.size());

        System.out.println(queue);
    }
}
package org.example.stack;

import org.example.stack.exceptions.EmptyMyStackException;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {
    @Test
    void testStack() throws EmptyMyStackException {
        System.out.println("Stack : ");
        MyStack<Integer> stack = new MyStack<>();

        System.out.println(stack);
        assertEquals(0, stack.size());

        for(int i = 0; i < 5; i++) {
            stack.push(i);
        }

        System.out.println(stack);
        assertEquals(4, stack.peek());
        assertEquals(5, stack.size());

        assertEquals(4, stack.pop());
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(2, stack.size());
        System.out.println(stack);

        stack.clear();
        assertEquals(0, stack.size());
        System.out.println(stack);

        try {
            stack.pop();
            fail();
        } catch(EmptyMyStackException e) {
            assertEquals(0, stack.size());
        }
    }
}
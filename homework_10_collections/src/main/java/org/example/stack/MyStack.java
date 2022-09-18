package org.example.stack;

import org.example.stack.exceptions.EmptyMyStackException;

import java.util.EmptyStackException;

public class MyStack<T> {
    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }

    private Node<T> head;
    private int size;

    public MyStack() {
        this.size = 0;
    }

    public void push(T value) {
        Node<T> toPush = new Node<>(value);
        toPush.next = head;
        head = toPush;
        size++;
    }

    public void clear() {
        for(Node<T> current = head; current != null; ) {
            Node<T> next = current.next;
            current.next = null;
            current.value = null;
            current = null;
            current = next;
        }

        head = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T peek() throws EmptyMyStackException {
        checkIsEmpty();
        return head.value;
    }

    public T pop() throws EmptyMyStackException {
        checkIsEmpty();
        T result = head.value;
        Node<T> toRemove = head;
        head = toRemove.next;

        toRemove.next = null;
        toRemove = null;
        size--;

        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for(Node<T> current = head; current != null; current = current.next) {
            builder.append(current.value);
            if(current.next != null) {
                builder.append(", ");
            }
        }

        return builder.append("]").toString();
    }

    private void checkIsEmpty() throws EmptyMyStackException {
        if(head == null) {
            throw new EmptyMyStackException("MyStack is empty");
        }
    }
}

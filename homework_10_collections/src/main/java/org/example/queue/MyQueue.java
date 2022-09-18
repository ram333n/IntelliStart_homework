package org.example.queue;

import org.example.queue.exceptions.EmptyMyQueueException;
import org.example.stack.MyStack;

public class MyQueue<T> {
    private static class Node<T> {
        T value;
        Node<T> next;
        Node<T> prev;

        public Node(T value) {
            this.value = value;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public MyQueue() {
        this.size = 0;
    }

    public void add(T value) {
        Node<T> toAdd = new Node<>(value);
        if(head == null) {
            tail = toAdd;
        } else {
            head.prev = toAdd;
        }

        toAdd.next = head;
        head = toAdd;
        size++;
    }

    public void clear() {
        for(Node<T> current = head; current != null;) {
            Node<T> next = current.next;
            current.value = null;
            current.prev = null;
            current.next = null;
            current = next;
        }

        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T peek() throws EmptyMyQueueException {
        checkIsEmpty();
        return tail.value;
    }

    public T poll() throws EmptyMyQueueException {
        checkIsEmpty();
        T result = tail.value;
        Node<T> toRemove = tail;

        if(toRemove.prev != null) {
            toRemove.prev.next = toRemove.next;
        } else {
            head = toRemove.next;
        }

        tail = toRemove.prev;

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

    private void checkIsEmpty() throws EmptyMyQueueException {
        if(head == null) {
            throw new EmptyMyQueueException("MyQueue is empty");
        }
    }
}
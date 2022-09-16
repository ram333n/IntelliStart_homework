package org.example.queue;

import org.example.lists.linked_list.MyLinkedList;

public class MyQueue<T> {
    private final MyLinkedList<T> list;

    public MyQueue() {
        this.list = new MyLinkedList<>();
    }

    public void add(T value) {
        list.addFirst(value);
    }

    public void clear() {
        list.clear();
    }

    public int size() {
        return list.size();
    }

    public T peek() {
        return list.getLast();
    }

    public T poll() {
        T result = list.getLast();
        list.removeLast();
        return result;
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
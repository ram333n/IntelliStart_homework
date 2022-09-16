package org.example.stack;

import org.example.lists.array_list.MyArrayList;

public class MyStack<T> {
    private final MyArrayList<T> list;

    public MyStack() {
        this.list = new MyArrayList<>();
    }

    public void push(T value) {
        list.add(value);
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

    public T pop() {
        T result = list.getLast();
        list.removeLast();
        return result;
    }

    @Override
    public String toString() {
        return list.toString();
    }
}

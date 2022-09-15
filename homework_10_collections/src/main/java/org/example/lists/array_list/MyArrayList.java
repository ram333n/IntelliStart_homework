package org.example.lists.array_list;

import org.example.lists.MyList;

import java.util.Arrays;

public class MyArrayList extends MyList {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] data;

    public MyArrayList() {
        data = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public void add(Object value) {
        increaseCapacity();
        data[size] = value;
        size++;
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        for(int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        data[size] = null;
        size--;
    }

    @Override
    public void clear() {
        for(int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    @Override
    public Object get(int index) {
        checkIndex(index);
        return data[index];
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for(int i = 0; i < size; i++) {
            builder.append(data[i]);
            if(i != size - 1) {
                builder.append(", ");
            }
        }

        return builder.append("]").toString();
    }

    private void increaseCapacity() {
        if(size < data.length) {
            return;
        }

        data = Arrays.copyOf(data, 2 * data.length);
    }
}

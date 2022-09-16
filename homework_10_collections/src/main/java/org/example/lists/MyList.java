package org.example.lists;

public abstract class MyList<T> {
    protected int size = 0;

    public abstract void add(T value);
    public abstract void remove(int index);
    public abstract void removeLast();
    public abstract void clear();
    public abstract T get(int index);
    public abstract T getLast();

    public int size() {
        return size;
    }

    protected void checkIndex(int index) {
        if(index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("MyList : index out of range");
        }
    }
}

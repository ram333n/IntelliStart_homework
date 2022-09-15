package org.example.lists;

public abstract class MyList {
    protected int size = 0;

    public abstract void add(Object value);
    public abstract void remove(int index);
    public abstract void clear();
    public abstract Object get(int index);

    public int size() {
        return size;
    }

    protected void checkIndex(int index) {
        if(index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("MyList : index out of range");
        }
    }
}

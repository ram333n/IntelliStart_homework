package org.example.lists.linked_list;

import org.example.lists.MyList;

public class MyLinkedList<T> extends MyList<T> {
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

    @Override
    public void add(T value) {
        Node<T> toAdd = new Node<>(value);
        if(tail == null) {
            head = toAdd;
        } else {
            tail.next = toAdd;
        }

        toAdd.prev = tail;
        tail = toAdd;
        size++;
    }

    @Override
    public void remove(int index) {
        removeNode(getNodeByIndex(index));
    }

    @Override
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

    @Override
    public T get(int index) {
        return getNodeByIndex(index).value;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for(Node<T> current = head; current != null; current = current.next) {
            builder.append(current.value);
            if(current != tail) {
                builder.append(", ");
            }
        }

        return builder.append("]").toString();
    }

    private Node<T> getNodeByIndex(int index) {
        checkIndex(index);
        Node<T> current = head;
        for(int i = 0; i < index; i++) {
            current = current.next;
        }

        return current;
    }

    private void removeNode(Node<T> toRemove) {
        if(toRemove.prev != null) {
            toRemove.prev.next = toRemove.next;
        } else {
            head = toRemove.next;
        }

        if(toRemove.next != null) {
            toRemove.next.prev = toRemove.prev;
        } else {
            tail = toRemove.prev;
        }

        toRemove = null;
        size--;
    }
}
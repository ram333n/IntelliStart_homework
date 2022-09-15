package org.example.lists.linked_list;

import org.example.lists.MyList;

public class MyLinkedList extends MyList {
    private static class Node {
        private Object value;
        private Node next;
        private Node prev;

        public Node(Object value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;

    @Override
    public void add(Object value) {
        Node toAdd = new Node(value);
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
        Node toRemove = getNodeByIndex(index);

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

    @Override
    public void clear() {
        for(Node current = head; current != null;) {
            Node next = current.next;
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
    public Object get(int index) {
        return getNodeByIndex(index).value;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for(Node current = head; current != null; current = current.next) {
            builder.append(current.value);
            if(current != tail) {
                builder.append(", ");
            }
        }

        return builder.append("]").toString();
    }

    private Node getNodeByIndex(int index) {
        checkIndex(index);
        Node current = head;
        for(int i = 0; i < index; i++) {
            current = current.next;
        }

        return current;
    }
}
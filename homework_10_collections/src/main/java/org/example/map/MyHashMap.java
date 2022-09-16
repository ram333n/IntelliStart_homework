package org.example.map;

public class MyHashMap<K, V> {
    private static class Node<K, V> {
        final K key;
        V value;
        Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }

    private static final int DEFAULT_CAPACITY = 16;
    private final Node<K, V>[] table;
    private int size;

    public MyHashMap(int capacity) {
        table = new Node<>[capacity];
        size = 0;
    }

    public MyHashMap() {
        this(DEFAULT_CAPACITY);
    }

    public boolean put(K key, V value) {
        if(findNodeByKey(key) == null) {
            return false;
        }

        int bucket = getBucketIndex(key);
        Node<K, V> toInsert = new Node<>(key, value);

        toInsert.next = table[bucket];
        table[bucket] = toInsert;
        size++;

        return true;
    }

    public V remove(K key) {
        Node<K, V> toRemove = findNodeByKey(key);
        if(toRemove == null) {
            return null;
        }

        int bucket = getBucketIndex(key);
        Node<K, V> current = table[bucket];

        if(current == toRemove) {
            table[bucket] = toRemove.next;
        } else {
            while(current.next != toRemove) {
                current = current.next;
            }

            current.next =  toRemove.next;
        }

        toRemove.next = null;
        size--;

        return toRemove.value;
    }

    public void clear() {
        for(int i = 0; i < table.length && size > 0; i++) {
            table[i] = null;
        }

        size = 0;
    }

    public int size() {
        return size;
    }

    public V get(K key) {
        Node<K, V> foundNode = findNodeByKey(key);
        return foundNode == null ? null : foundNode.value;
    }

    private int getBucketIndex(K key) {
        return key.hashCode() % table.length;
    }

    private Node<K, V> findNodeByKey(K key) {
        Node<K, V> current = table[getBucketIndex(key)];

        while(current != null) {
            if(current.key.equals(key)) {
                break;
            }
            current = current.next;
        }

        return current;
    }
}

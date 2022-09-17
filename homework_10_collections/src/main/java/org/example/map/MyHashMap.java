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
        table = new Node[capacity];
        size = 0;
    }

    public MyHashMap() {
        this(DEFAULT_CAPACITY);
    }

    public boolean put(K key, V value) {
        int bucket = getBucketIndex(key);

        if(findNodeByKey(key, bucket) != null) {
            return false;
        }

        Node<K, V> toInsert = new Node<>(key, value);

        toInsert.next = table[bucket];
        table[bucket] = toInsert;
        size++;

        return true;
    }

    public V remove(K key) {
        int bucket = getBucketIndex(key);
        Node<K, V> toRemove = findNodeByKey(key, bucket);

        if(toRemove == null) {
            return null;
        }

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
        Node<K, V> foundNode = findNodeByKey(key, getBucketIndex(key));
        return foundNode == null ? null : foundNode.value;
    }

    private int getBucketIndex(K key) {
        return key.hashCode() % table.length;
    }

    private Node<K, V> findNodeByKey(K key, int bucket) {
        Node<K, V> current = table[bucket];

        while(current != null) {
            if(current.key.equals(key)) {
                break;
            }
            current = current.next;
        }

        return current;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        int count = 0;

        for(int i = 0; i < table.length && count < size; i++) {
            for(Node<K, V> current = table[i]; current != null; current = current.next) {
                builder.append("{");
                builder.append(current.key);
                builder.append(", ");
                builder.append(current.value);
                builder.append("}");
                count++;

                if(count != size) {
                    builder.append(", ");
                }
            }
        }

        return builder.append("]").toString();
    }
}

package org.example.sort;

import java.util.Comparator;

public interface Sorter<T> {
    void sort(T[] array, Comparator<T> comparator);
}
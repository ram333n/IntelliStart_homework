package org.example.sort;

import java.util.Comparator;

/**
 * This class contains Quicksort middle pivot algorithm implementation.
 * Best case complexity : O(n*log(n))
 * Average case : O(n*log(n))
 * Worst case : O(n^2) (when array is almost sorted)
 * */
public class QuickSorter<T> implements Sorter<T> {
    @Override
    public void sort(T[] array, Comparator<T> comparator) {
        quickSortImpl(array, 0, array.length - 1, comparator);
    }

    private void quickSortImpl(T[] array, int low, int high, Comparator<T> comparator) {
        if(low >= high) {
            return;
        }

        int p = partition(array, low, high, comparator);
        quickSortImpl(array, low, p, comparator);
        quickSortImpl(array, p + 1, high, comparator);
    }

    private int partition(T[] array, int low, int high, Comparator<T> comparator) {
        T pivot = array[(low + high) / 2];
        int i = low;
        int j = high;

        while(true) {
            while(comparator.compare(array[i], pivot) < 0) {
                i++;
            }

            while(comparator.compare(pivot, array[j]) < 0) {
                j--;
            }

            if(i >= j) {
                return j;
            }

            swap(array, i, j);
            i++;
            j--;
        }
    }

    private void swap(T[] array, int leftIdx, int rightIdx) {
        T temp = array[leftIdx];
        array[leftIdx] = array[rightIdx];
        array[rightIdx] = temp;
    }
}
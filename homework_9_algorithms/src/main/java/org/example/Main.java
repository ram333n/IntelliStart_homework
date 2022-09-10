package org.example;

import org.example.sort.QuickSorter;
import org.example.sort.Sorter;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Integer[] array = {-1,2,-3,4,10,-4242};
        Sorter<Integer> sorter = new QuickSorter<>();
        sorter.sort(array, Comparator.reverseOrder());
        System.out.println(Arrays.toString(array));
    }
}
package org.example.counter;

import org.example.person.Person;
import org.example.sort.QuickSorter;
import org.example.sort.Sorter;


/**
 * This class contains static method, which finds count of unique pairs of weight and height. It uses Quicksort, which implemented in QuickSorter class
 * Best case complexity : O(n*log(n))
 * Average case compexity : O(n*log(n))
 * Worst case complexity : O(n^2)
 * */
public class UserCounter {
    private UserCounter(){}
    public static int count(Person[] array) {
        if(array.length < 1) {
            return 0;
        }

        Sorter<Person> quickSorter = new QuickSorter<>();
        quickSorter.sort(array, (lhs, rhs) -> {
            int weightComparison = lhs.getWeight() - rhs.getWeight();
            if(weightComparison == 0) {
                return lhs.getHeight() - rhs.getHeight();
            }

            return weightComparison;
        });

        int result = 1;
        int currentWeight = array[0].getWeight();
        int currentHeight = array[0].getHeight();

        for(int i = 1; i < array.length; i++) {
            if(currentWeight == array[i].getWeight() && currentHeight == array[i].getHeight()) {
                continue;
            }

            currentWeight = array[i].getWeight();
            currentHeight = array[i].getHeight();
            result++;
        }

        return result;
    }
}

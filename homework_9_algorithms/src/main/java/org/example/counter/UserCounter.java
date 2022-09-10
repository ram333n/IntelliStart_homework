package org.example.counter;

import org.example.person.Person;
import org.example.sort.QuickSorter;
import org.example.sort.Sorter;

public class UserCounter {
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

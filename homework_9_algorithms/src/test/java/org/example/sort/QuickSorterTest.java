package org.example.sort;

import org.example.person.Person;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class QuickSorterTest {
    private <T> boolean isSorted(T[] array, Comparator<T> comparator) {
        for(int i = 0; i < array.length - 1; i++) {
            if(comparator.compare(array[i], array[i + 1]) > 0) {
                return false;
            }
        }

        return true;
    }

    @Test
    void sortByAgeAndWeight() {
        Person[] array = new Person[] {
            new Person(160, 80, 16),
            new Person(180, 100, 19),
            new Person(130, 40, 13),
            new Person(200, 130, 30),
            new Person(183, 98, 20),
            new Person(60, 4, 0),
            new Person(100, 15, 2),
            new Person(120, 15, 2)
        };


        Sorter<Person> sorter = new QuickSorter<>();
        sorter.sort(array, Comparator.comparingInt(Person::getAge));
        assertTrue(isSorted(array, Comparator.comparingInt(Person::getAge)));

        sorter.sort(array, Comparator.comparingInt(Person::getWeight));
        assertTrue(isSorted(array, Comparator.comparingInt(Person::getWeight)));
    }

    @Test
    void cornerCases() {
        // if exceptions aren't thrown, then this test is correct

        Person[] array = new Person[0];
        Sorter<Person> sorter = new QuickSorter<>();
        sorter.sort(array, Comparator.comparingInt(Person::getAge));

        array = new Person[] {
            new Person(0, 0, 0)
        };
        sorter.sort(array, Comparator.comparingInt(Person::getAge));
    }

    @Test
    void profileQuickAndLibrarySorts() {
        final int TEST_SIZE = 2_000_000;
        final int BOUND = 100_000;
        Random random = new Random();
        Sorter<Person> personSorter = new QuickSorter<>();

        Person[] arrayForQuickSort = new Person[TEST_SIZE];
        Person[] arrayForLibrarySort = new Person[TEST_SIZE];

        for(int i = 0; i < TEST_SIZE; i++) {
            int height = random.nextInt(BOUND);
            int weight = random.nextInt(BOUND);
            int age = random.nextInt(BOUND);

            arrayForQuickSort[i] = new Person(height, weight, age);
            arrayForLibrarySort[i] = new Person(height, weight, age);
        }

        long start = 0;
        long finish = 0;

        start = System.currentTimeMillis();
        personSorter.sort(arrayForQuickSort, Comparator.comparingInt(Person::getAge));
        finish = System.currentTimeMillis();
        System.out.printf("Quick sort : %d ms\n", finish - start);

        start = System.currentTimeMillis();
        Arrays.sort(arrayForLibrarySort, Comparator.comparingInt(Person::getAge));
        finish = System.currentTimeMillis();
        System.out.printf("Arrays.sort() : %d ms\n", finish - start);

        assertTrue(isSorted(arrayForLibrarySort, Comparator.comparingInt(Person::getAge)));
        assertTrue(isSorted(arrayForQuickSort, Comparator.comparingInt(Person::getAge)));
    }
}
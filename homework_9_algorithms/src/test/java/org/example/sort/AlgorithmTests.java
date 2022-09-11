package org.example.sort;

import org.example.counter.UserCounter;
import org.example.person.Person;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class AlgorithmTests {
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
    void sortCornerCases() {
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

    @Test
    void sortByWeightHeightComparator() {
        Person[] array = new Person[] {
            new Person(160, 80, 16),
            new Person(180, 100, 19),
            new Person(130, 40, 13),
            new Person(200, 130, 30),
            new Person(183, 98, 20),
            new Person(60, 4, 0),
            new Person(80, 4, 0),
            new Person(100, 15, 2),
            new Person(120, 15, 2),
            new Person(135, 80, 20),
            new Person(180, 80, 23)
        };

        Sorter<Person> sorter = new QuickSorter<>();
        Comparator<Person> comparator = (lhs, rhs) -> {
            int weightComparison = lhs.getWeight() - rhs.getWeight();
            if(weightComparison == 0) {
                return lhs.getHeight() - rhs.getHeight();
            }

            return weightComparison;
        };

        sorter.sort(array, comparator);
        assertTrue(isSorted(array, comparator));
    }

    @Test
    void testUserCounter() {
        Person[] array = new Person[] {
            new Person(160, 80, 16),  //1
            new Person(180, 100, 19), //2
            new Person(130, 40, 13),  //3
            new Person(200, 130, 30), //4
            new Person(183, 98, 20),  //5
            new Person(60, 4, 0),     //6
            new Person(80, 4, 0),     //7
            new Person(80, 4, 1),     //7
            new Person(100, 15, 2),   //8
            new Person(120, 15, 2),   //8
            new Person(135, 80, 20),  //10
            new Person(180, 80, 23),  //11
            new Person(180, 80, 25),  //11
            new Person(80, 4, 1),     //11
            new Person(160, 80, 18),  //11
            new Person(183, 98, 54),  //11
            new Person(200, 130, 70)  //11
        };

        int expected = 11;
        assertEquals(UserCounter.count(array), expected);
    }
}
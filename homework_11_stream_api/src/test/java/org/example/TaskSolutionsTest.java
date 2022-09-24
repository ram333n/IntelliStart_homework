package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class TaskSolutionsTest {
    private List<String> initInput() {
        List<String> testInput = new ArrayList<>();

        testInput.add("Roman");
        testInput.add("Ivan");
        testInput.add("Petro");
        testInput.add("Peter");
        testInput.add("Viktor");
        testInput.add("Stepan");
        testInput.add("Kyrylo");
        testInput.add("Andrii");

        return testInput;
    }

    @Test
    void testGetOddNames() {
        List<String> testInput = initInput();

        String expected1 = "1. Ivan, 3. Peter, 5. Stepan, 7. Andrii";
        String expected2 = "";
        String expected3 = "1. Roman";

        assertEquals(expected1, TaskSolutions.getOddNames(testInput));
        assertEquals(expected2, TaskSolutions.getOddNames(List.of("Test")));
        assertEquals(expected3, TaskSolutions.getOddNames(List.of("A", "Roman", "B")));
    }

    @Test
    void testToUpperAndSort() {
        List<String> testInput = initInput();

        String expected = "VIKTOR, STEPAN, ROMAN, PETRO, PETER, KYRYLO, IVAN, ANDRII";
        assertEquals(expected, TaskSolutions.toUpperCaseAndSort(testInput));
    }

    @Test
    void testSortSerializedNumbers() {
        String[] input1 = {"1, 2, 0", "4, 5"};
        String[] input2 = {"3, 1, 2", "      -1        ", "9,  10"};
        String[] input3 = {" 2     "};
        String[] input4 = {" \t"};
        String[] input5 = {"", "2"};

        String expected1 = "0, 1, 2, 4, 5";
        String expected2 = "-1, 1, 2, 3, 9, 10";
        String expected3 = "2";
        String expected4 = "";
        String expected5 = "2";

        assertEquals(expected1, TaskSolutions.sortSerializedNumbers(input1));
        assertEquals(expected2, TaskSolutions.sortSerializedNumbers(input2));
        assertEquals(expected3, TaskSolutions.sortSerializedNumbers(input3));
        assertEquals(expected4, TaskSolutions.sortSerializedNumbers(input4));
        assertEquals(expected5, TaskSolutions.sortSerializedNumbers(input5));
    }

    @Test
    void testGenerateStreamOfLongs() {
        final long seed = 0L;
        final long a = 25_214_903_917L;
        final long c = 11;
        final long m = 1L << 48;
        List<Long> expected = new ArrayList<>();

        expected.add(0L);
        expected.add(11L);
        expected.add(277_363_943_098L);
        expected.add(11_718_085_204_285L);
        expected.add(49_720_483_695_876L);
        expected.add(102_626_409_374_399L);
        expected.add(25_707_281_917_278L);
        expected.add(25_979_478_236_433L);
        expected.add(137_139_456_763_464L);
        expected.add(148_267_022_728_371L);

        List<Long> actualNumbers = TaskSolutions.generateStreamOfLongs(seed, a, c, m)
                .limit(10)
                .toList();

        assertEquals(expected, actualNumbers);
    }

    @Test
    void testZip() {
        List<Integer> first1 = List.of(1, 3, 5, 7, 9, 11);
        List<Integer> second1 = List.of(2, 4, 6, 8);
        List<Integer> expected1 = List.of(1, 2, 3, 4, 5, 6, 7, 8);

        List<Integer> first2 = List.of(1, 3, 5, 7, 9);
        List<Integer> second2 = List.of();
        List<Integer> expected2 = List.of();

        List<Integer> first3 = List.of();
        List<Integer> second3 = first2;
        List<Integer> expected3 = List.of();

        List<Integer> first4 = List.of(1, 3, 5, 7, 9, 11);
        List<Integer> second4 = List.of(2, 4, 6, 8, 10, 12, 14, 16);
        List<Integer> expected4 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);

        assertEquals(expected1, TaskSolutions.zip(first1.stream(), second1.stream()).toList());
        assertEquals(expected2, TaskSolutions.zip(first2.stream(), second2.stream()).toList());
        assertEquals(expected3, TaskSolutions.zip(first3.stream(), second3.stream()).toList());
        assertEquals(expected4, TaskSolutions.zip(first4.stream(), second4.stream()).toList());
    }
}
package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        String expected1 = "0, 1, 2, 4, 5";
        String expected2 = "-1, 1, 2, 3, 9, 10";
        String expected3 = "2";

        assertEquals(expected1, TaskSolutions.sortSerializedNumbers(input1));
        assertEquals(expected2, TaskSolutions.sortSerializedNumbers(input2));
        assertEquals(expected3, TaskSolutions.sortSerializedNumbers(input3));
    }

}
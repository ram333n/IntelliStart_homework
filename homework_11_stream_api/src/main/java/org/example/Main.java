package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> testInput = new ArrayList<>();

        testInput.add("Roman");
        testInput.add("Ivan");
        testInput.add("Petro");
        testInput.add("Peter");
        testInput.add("Viktor");
        testInput.add("Stepan");
        testInput.add("Kyrylo");
        testInput.add("Andrii");

        System.out.println(TaskSolutions.getOddNames(testInput));
        System.out.println(TaskSolutions.toUpperCaseAndSort(testInput));
    }
}
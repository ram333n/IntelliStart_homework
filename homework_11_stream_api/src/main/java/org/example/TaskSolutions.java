package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class TaskSolutions {
    private TaskSolutions() {}

    public static String getOddNames(List<String> names) { //task 1
        return IntStream
                .range(0, names.size())
                .filter(i -> i % 2 > 0)
                .mapToObj(i -> String.format("%d. %s", i, names.get(i)))
                .collect(Collectors.joining(", "));
    }

    public static String toUpperCaseAndSort(List<String> names) { //task 2
        return names.stream()
                .map(str -> str.toUpperCase())
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining(", "));
    }
}

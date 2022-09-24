package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

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
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining(", "));
    }

    public static String sortSerializedNumbers(String[] array) { //task 3
        return Arrays.stream(String.join(",", array).split("\s*,\s*"))
                .map(String::trim)
                .filter((str) -> !str.isEmpty())
                .mapToInt(Integer::parseInt)
                .sorted()
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(", "));
    }

    public static Stream<Long> generateStreamOfLongs(long seed, long a, long c, long m) { //task 4
        return Stream.iterate(seed, i -> (a * i + c) % m);
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) { //task 5
        Iterator<T> firstIt = first.iterator();
        Iterator<T> secondIt = second.iterator();
        Stream.Builder<T> builder = Stream.builder();

        while(firstIt.hasNext() && secondIt.hasNext()) {
            builder.add(firstIt.next()).add(secondIt.next());
        }

        return builder.build();
    }
}
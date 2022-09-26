package org.example.task_3;

import org.example.util.PathBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class WordCounter {
    private final Map<String, Integer> map;
    private final String fileName;

    public WordCounter(String fileName) {
        this.fileName = fileName;
        map = new HashMap<>();
    }

    public void count() {
        try(Scanner scanner = new Scanner(new FileInputStream(fileName));) {
            while(scanner.hasNext()) {
                String current = scanner.next();
                map.merge(current, 1, Integer::sum);
            }

            List<Map.Entry<String, Integer>> sortedEntries = map.entrySet().stream()
                    .sorted((lhs, rhs) -> rhs.getValue() - lhs.getValue())
                    .toList();

            for(Map.Entry<String, Integer> entry : sortedEntries) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        WordCounter counter = new WordCounter(PathBuilder.getPath(".", "input", "task_3.txt"));
        counter.count();
    }
}

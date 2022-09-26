package org.example.task_1;

import org.example.util.PathBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PhonePrinter {
    private final String pattern = "^((\\(\\d{3}\\)\\ )|(\\d{3}-))\\d{3}-\\d{4}$";
    private final String fileName;

    public PhonePrinter(String fileName) {
        this.fileName = fileName;
    }

    public void printPhoneNumbers() {
        try(Scanner scanner = new Scanner(new FileInputStream(fileName));) {
            while(scanner.hasNext()) {
                String currentLine = scanner.nextLine();

                if(currentLine.matches(pattern)) {
                    System.out.println(currentLine);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        PhonePrinter printer = new PhonePrinter(PathBuilder.getPath(".", "input", "task_1.txt"));
        printer.printPhoneNumbers();
    }
}
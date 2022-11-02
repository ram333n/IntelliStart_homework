package org.example.task_2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.util.PathBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class UserJSONSerializer {
    private final String fileName;

    public UserJSONSerializer(String fileName) {
        this.fileName = fileName;
    }

    public void serialize() {
        try(Scanner scanner = new Scanner(new FileInputStream(fileName));
            FileWriter writer = new FileWriter(PathBuilder.getPath(".", "output", "task_2.json"));) {
            List<User> users = new ArrayList<>();
            scanner.nextLine(); //it's useless :)

            String currentName = "";
            String currentAgeString = "";

            while(scanner.hasNext()) {
                currentName = scanner.next();
                Integer currentAge = 0;

                try {
                    currentAgeString = scanner.next();
                    currentAge = Integer.parseInt(currentAgeString);
                } catch (NumberFormatException | NoSuchElementException e) {
                    continue;
                }

                users.add(new User(currentName, currentAge));
            }

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(users, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        UserJSONSerializer serializer = new UserJSONSerializer(PathBuilder.getPath(".", "input", "task_2.txt"));
        serializer.serialize();
    }
}

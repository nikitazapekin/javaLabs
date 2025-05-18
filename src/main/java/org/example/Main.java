package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User(1, "Иванов Иван Иванович", 45),
                new User(2, "Петров Петр Петрович", 30),
                new User(3, "Алексеев Алексей Алексеевич", 25),
                new User(4, "Сидоров Сидор Сидорович", 50)
        );


        UserSelector getOldest = userList -> userList.stream()
                .max(Comparator.comparingInt(User::getAge))
                .orElse(null);

        UserSelector getYoungest = userList -> userList.stream()
                .min(Comparator.comparingInt(User::getAge))
                .orElse(null);

        UserSelector getFirstAlphabetical = userList -> userList.stream()
                .min(Comparator.comparing(User::getFullName))
                .orElse(null);

        UserSelector getLastAlphabetical = userList -> userList.stream()
                .max(Comparator.comparing(User::getFullName))
                .orElse(null);


        System.out.println("Самый старший: " + getOldest.select(users));
        System.out.println("Самый младший: " + getYoungest.select(users));
        System.out.println("Первый по алфавиту: " + getFirstAlphabetical.select(users));
        System.out.println("Последний по алфавиту: " + getLastAlphabetical.select(users));
    }
}
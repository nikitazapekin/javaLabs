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
        System.out.println("Самый старший: " + UserSelectors.OLDEST.select(users));
        System.out.println("Самый младший: " + UserSelectors.YOUNGEST.select(users));
        System.out.println("Первый по алфавиту: " + UserSelectors.FIRST_ALPHABETICAL.select(users));
        System.out.println("Последний по алфавиту: " + UserSelectors.LAST_ALPHABETICAL.select(users));
    }
}
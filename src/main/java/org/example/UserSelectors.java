package org.example;


import org.example.User;
import org.example.UserSelector;
import java.util.Comparator;
import java.util.List;

public class UserSelectors {
    public static final UserSelector OLDEST = users -> users.stream()
            .max(Comparator.comparingInt(User::getAge))
            .orElse(null);

    public static final UserSelector YOUNGEST = users -> users.stream()
            .min(Comparator.comparingInt(User::getAge))
            .orElse(null);

    public static final UserSelector FIRST_ALPHABETICAL = users -> users.stream()
            .min(Comparator.comparing(User::getFullName))
            .orElse(null);

    public static final UserSelector LAST_ALPHABETICAL = users -> users.stream()
            .max(Comparator.comparing(User::getFullName))
            .orElse(null);
}
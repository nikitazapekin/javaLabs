package org.example;


import org.example.User;
import org.example.UserSelector;
import java.util.Comparator;
import java.util.List;

public class UserSelectors {



    public static final UserSelector OLDEST = users -> {
        User oldest = null;
        for (User user : users)
            if (oldest == null || user.getAge() > oldest.getAge())
                oldest = user;
        return oldest;
    };

    public static final UserSelector YOUNGEST = users -> {
        User youngest = null;
        for (User user : users)
            if (youngest == null || user.getAge() < youngest.getAge())
                youngest = user;
        return youngest;
    };

    public static final UserSelector FIRST_ALPHABETICAL = users -> {
        User first = null;
        for (User user : users)
            if (first == null || user.getFullName().compareTo(first.getFullName()) < 0)
                first = user;
        return first;
    };

    public static final UserSelector LAST_ALPHABETICAL = users -> {
        User last = null;
        for (User user : users)
            if (last == null || user.getFullName().compareTo(last.getFullName()) > 0)
                last = user;
        return last;
    };


    /* public static final UserSelector OLDEST = users -> users.stream()
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

     */
}
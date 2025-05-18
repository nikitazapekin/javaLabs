package org.example;

import java.util.List;

@FunctionalInterface
public interface UserSelector {
    User select(List<User> users);
}
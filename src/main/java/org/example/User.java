package org.example;

public class User {
    private final int id;
    private final String fullName;
    private final int age;

    public User(int id, String fullName, int age) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
    }
    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{id=" + id + ", fullName='" + fullName + "', age=" + age + "}";
    }
}
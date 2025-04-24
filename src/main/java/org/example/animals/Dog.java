package org.example.animals;

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Собака "+ getName() + " гавкает!");
    }

    public void bite() {
        System.out.println("Собака "+ getName() + " кусает");
    }

    @Override
    public String toString() {
        return "Dog{name='" + getName() + "'}";
    }
}
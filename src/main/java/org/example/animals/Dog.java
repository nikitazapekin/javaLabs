package org.example.animals;

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " гавкает!");
    }

    public void bite() {
        System.out.println(getName() + " кусает");
    }

    @Override
    public String toString() {
        return "Dog{name='" + getName() + "'}";
    }
}
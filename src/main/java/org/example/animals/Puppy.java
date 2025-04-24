package org.example.animals;


public class Puppy extends Dog {
    public Puppy(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Щенок "+ getName() + " гавкает");
    }

    @Override
    public void run() {
        System.out.println("Щенок " +getName() + " бегает");
    }

    @Override
    public void jump() {
        System.out.println("Щенок "+getName() + " прыгает");
    }

    @Override
    public void bite() {
        System.out.println("Щенок "+getName() + " кусает");
    }

    @Override
    public String toString() {
        return "Puppy{name='" + getName() + "'}";
    }
}
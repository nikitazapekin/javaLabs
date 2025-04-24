package org.example;


import org.example.animals.Dog;
import org.example.animals.Puppy;

public class Main {
    public static void main(String[] args) {



            Puppy myPuppy = new Puppy("Rex");

            System.out.println("Puppy's name: " + myPuppy.getName());


            myPuppy.makeSound();
            myPuppy.jump();
            myPuppy.run();
            myPuppy.bite();


            System.out.println(myPuppy);




        Puppy myPuppy1 = new Puppy("Rex");
            System.out.println(myPuppy.equals(myPuppy1));

        Dog myPuppy2 = new Dog("Rex");
        System.out.println(myPuppy.equals(myPuppy2));
        }

    }

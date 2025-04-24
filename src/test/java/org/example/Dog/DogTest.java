package org.example.Dog;




import org.example.animals.Animal;
import org.example.animals.Dog;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DogTest {

    private Dog dog;
    private final String dogName = "Рекс";

    @BeforeAll
    static void beforeAll() {
        System.out.println("Начало тестирования класса Dog");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Завершение тестирования класса Dog");
    }

    @BeforeEach
    void setUp() {
        dog = new Dog(dogName);
    }

    @AfterEach
    void tearDown() {
        System.out.println("Тест завершен");
    }

    @Test
    void testDogCreation() {
        assertNotNull(dog);
        assertEquals(dogName, dog.getName());
    }

    @Test
    void testDogIsAnimal() {
        assertTrue(dog instanceof Animal);
    }


    @Test
    void testMakeSound() {
        assertDoesNotThrow(() -> dog.makeSound());
    }

    @Test
    void testBite() {
        assertDoesNotThrow(() -> dog.bite());
    }


    @Test
    void testRun() {
        assertDoesNotThrow(() -> dog.run());
    }

    @Test
    void testJump() {
        assertDoesNotThrow(() -> dog.jump());
    }


    @Test
    void testEquals() {
        Dog sameDog = new Dog(dogName);
        Dog differentDog = new Dog("Шарик");
        Animal animalWithSameName = new Animal(dogName);

        assertEquals(dog, sameDog);
        assertNotEquals(dog, differentDog);
        assertNotEquals(dog, animalWithSameName);
        assertNotEquals(dog, null);
    }

    @Test
    void testHashCode() {
        Dog sameDog = new Dog(dogName);
        assertEquals(dog.hashCode(), sameDog.hashCode());
    }

    @Test
    void testToString() {
        String expected = "Dog{name='" + dogName + "'}";
        assertEquals(expected, dog.toString());
    }


}
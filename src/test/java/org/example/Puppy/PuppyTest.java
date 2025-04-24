package org.example.Puppy;


import org.example.animals.Animal;
import org.example.animals.Dog;
import org.example.animals.Puppy;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PuppyTest {

    private Puppy puppy;
    private final String puppyName = "Бобик";

    @BeforeAll
    static void beforeAll() {
        System.out.println("Начало тестирования класса Puppy");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Завершение тестирования класса Puppy");
    }

    @BeforeEach
    void setUp() {
        puppy = new Puppy(puppyName);
    }

    @AfterEach
    void tearDown() {
        System.out.println("Тест завершен");
    }

    @Test
    void testPuppyCreation() {
        assertNotNull(puppy);
        assertEquals(puppyName, puppy.getName());
    }

    @Test
    void testPuppyIsDog() {
        assertTrue(puppy instanceof Dog);
    }

    @Test
    void testPuppyIsAnimal() {
        assertTrue(puppy instanceof Animal);
    }

    @Test
    void testMakeSound() {
        assertDoesNotThrow(() -> puppy.makeSound());
    }

    @Test
    void testRun() {
        assertDoesNotThrow(() -> puppy.run());
    }

    @Test
    void testJump() {
        assertDoesNotThrow(() -> puppy.jump());
    }

    @Test
    void testBite() {
        assertDoesNotThrow(() -> puppy.bite());
    }

    @Test
    void testEquals() {
        Puppy samePuppy = new Puppy(puppyName);
        Puppy differentPuppy = new Puppy("Шарик");
        Dog dogWithSameName = new Dog(puppyName);

        assertEquals(puppy, samePuppy);
        assertNotEquals(puppy, differentPuppy);
        assertNotEquals(puppy, dogWithSameName);
        assertNotEquals(puppy, null);
    }

    @Test
    void testHashCode() {
        Puppy samePuppy = new Puppy(puppyName);
        assertEquals(puppy.hashCode(), samePuppy.hashCode());
    }

    @Test
    void testToString() {
        String expected = "Puppy{name='" + puppyName + "'}";
        assertEquals(expected, puppy.toString());
    }


}
package org.example.Animal;
import org.example.animals.Animal;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AnimalTest {

    private Animal animal;
    private Animal anotherAnimal;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Начало тестирования класса Animal");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Завершение тестирования класса Animal");
    }

    @BeforeEach
    void setUp() {
        animal = new Animal("Барсик");
        anotherAnimal = new Animal("Рекс");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Тест завершен");
    }

    @Test
    void testAnimalCreation() {
        assertNotNull(animal);
        assertEquals("Барсик", animal.getName());
    }

    @Test
    void testSetName() {
        animal.setName("Мурзик");
        assertEquals("Мурзик", animal.getName());
    }

    @Test
    void testMakeSound() {
        assertDoesNotThrow(() -> animal.makeSound());
    }

    @Test
    void testRun() {
        assertDoesNotThrow(() -> animal.run());
    }

    @Test
    void testJump() {
        assertDoesNotThrow(() -> animal.jump());
    }

    @Test
    void testEquals() {
        Animal sameAnimal = new Animal("Барсик");
        Animal differentAnimal = new Animal("Шарик");

        assertEquals(animal, sameAnimal);
        assertNotEquals(animal, differentAnimal);
        assertNotEquals(animal, null);
        assertNotEquals(animal, new Object());
    }

    @Test
    void testHashCode() {
        Animal sameAnimal = new Animal("Барсик");
        assertEquals(animal.hashCode(), sameAnimal.hashCode());
    }

    @Test
    void testToString() {
        String expected = "Animal{name='Барсик'}";
        assertEquals(expected, animal.toString());
    }


}
/*package org.example.Animal;

public class AnimalTest {
}


 */
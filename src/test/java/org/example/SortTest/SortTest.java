package org.example.SortTest;



import org.example.helpers.sortMethods;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SortTest {

    private String[] testStrings;
    private String[] testStringsLowerCase;
    @BeforeAll
    static void beforeAll() {
        System.out.println("Начало тестирования UserSelector");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Завершение тестирования UserSelector");
    }

    @BeforeEach
    void setUp() {
        testStrings = new String[]{
                "Java Programming",
                "Spring Framework",
                "Hibernate ORM",
                "JUnit Testing",
                "Mockito Framework"
        };

        testStringsLowerCase = new String[]{
                "Hello", "WORLD", "Java", "sORTing", "Example"
        };
        sortMethods.comparisonCount = 0;
    }
    @AfterEach
    void testDown() {
        System.out.println("Тест завершен");
    }

    @Test
    void sortByLetter() {
        String substring = "s";
        String[] sortedBySubstring = sortArray(testStrings, sortMethods.bySubstringPosition(substring),
                "по позиции первого вхождения '" + substring + "'");
        assertEquals("Java Programming", sortedBySubstring[0]);
        assertTrue(sortMethods.comparisonCount > 0);
    }

    @Test
    void sortByLowerCase() {
        String[] sortedByLowerCase = sortArray(testStringsLowerCase, sortMethods.byLowerCaseCount(),
                "по количеству маленьких букв");

        assertEquals("WORLD", sortedByLowerCase[0]);
        assertTrue(sortMethods.comparisonCount > 0);
    }
    private static String[] sortArray(String[] array, Comparator<String> comparator, String description) {
        String[] sortedArray = Arrays.copyOf(array, array.length);
        sortMethods.comparisonCount = 0;
        Arrays.sort(sortedArray, comparator);

printArray(sortedArray);
        return sortedArray;
    }

    private static void printArray(String[] array) {
        for (String s : array) {
            System.out.println(s);
        }
    }



}
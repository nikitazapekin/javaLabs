package org.example.UserTest;


import org.example.User;
import org.example.UserSelector;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.example.UserSelectors;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserTest {

    private List<User> testUsers;
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
        testUsers = Arrays.asList(
                new User(1, "Иванов Иван Иванович", 45),
                new User(2, "Петров Петр Петрович", 30),
                new User(3, "Алексеев Алексей Алексеевич", 25),
                new User(4, "Сидоров Сидор Сидорович", 50)
        );
    }
    @AfterEach
    void testDown() {
        System.out.println("Тест завершен");
    }
    @Test
    void testGetOldestUser() {
        User oldest = UserSelectors.OLDEST.select(testUsers);
        assertNotNull(oldest);
        assertEquals(50, oldest.getAge());
        assertEquals("Сидоров Сидор Сидорович", oldest.getFullName());
    }
    @Test
    void testGetYoungestUser() {
        User youngest = UserSelectors.YOUNGEST.select(testUsers);
        assertNotNull(youngest);
        assertEquals(25, youngest.getAge());
        assertEquals("Алексеев Алексей Алексеевич", youngest.getFullName());
    }

    @Test
    void testGetFirstAlphabeticalUser() {
        User first = UserSelectors.FIRST_ALPHABETICAL.select(testUsers);
        assertNotNull(first);
        assertEquals("Алексеев Алексей Алексеевич", first.getFullName());
    }
    @Test
    void testGetLastAlphabeticalUser() {
        User last = UserSelectors.LAST_ALPHABETICAL.select(testUsers);
        assertNotNull(last);
        assertEquals("Сидоров Сидор Сидорович", last.getFullName());
    }
}
package org.example.UserTest;


import org.example.User;
import org.example.UserSelector;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserTest {

    private List<User> testUsers;
    private UserSelector getOldest;
    private UserSelector getYoungest;
    private UserSelector getFirstAlphabetical;
    private UserSelector getLastAlphabetical;

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

        getOldest = users -> users.stream()
                .max(Comparator.comparingInt(User::getAge))
                .orElse(null);

        getYoungest = users -> users.stream()
                .min(Comparator.comparingInt(User::getAge))
                .orElse(null);

        getFirstAlphabetical = users -> users.stream()
                .min(Comparator.comparing(User::getFullName))
                .orElse(null);

        getLastAlphabetical = users -> users.stream()
                .max(Comparator.comparing(User::getFullName))
                .orElse(null);
    }

    @AfterEach
    void testDown() {
        System.out.println("Тест завершен");
    }

    @Test
    void testGetOldestUser() {
        User oldest = getOldest.select(testUsers);
        assertNotNull(oldest);
        assertEquals(50, oldest.getAge());
        assertEquals("Сидоров Сидор Сидорович", oldest.getFullName());
    }

    @Test
    void testGetYoungestUser() {
        User youngest = getYoungest.select(testUsers);
        assertNotNull(youngest);
        assertEquals(25, youngest.getAge());
        assertEquals("Алексеев Алексей Алексеевич", youngest.getFullName());
    }

    @Test
    void testGetFirstAlphabeticalUser() {
        User first = getFirstAlphabetical.select(testUsers);
        assertNotNull(first);
        assertEquals("Алексеев Алексей Алексеевич", first.getFullName());
    }

    @Test
    void testGetLastAlphabeticalUser() {
        User last = getLastAlphabetical.select(testUsers);
        assertNotNull(last);
        assertEquals("Сидоров Сидор Сидорович", last.getFullName());
    }

    @Test
    void testEmptyList() {
        List<User> emptyList = List.of();

        assertNull(getOldest.select(emptyList));
        assertNull(getYoungest.select(emptyList));
        assertNull(getFirstAlphabetical.select(emptyList));
        assertNull(getLastAlphabetical.select(emptyList));
    }

    @Test
    void testSingleUserList() {
        List<User> singleUserList = List.of(new User(5, "Тестов Тест Тестович", 35));

        User user = getOldest.select(singleUserList);
        assertNotNull(user);
        assertEquals(35, user.getAge());
        assertEquals("Тестов Тест Тестович", user.getFullName());

        assertSame(user, getYoungest.select(singleUserList));
        assertSame(user, getFirstAlphabetical.select(singleUserList));
        assertSame(user, getLastAlphabetical.select(singleUserList));
    }

    @Test
    void testUserProperties() {
        User user = testUsers.get(0);
        assertEquals(1, user.getId());
        assertEquals("Иванов Иван Иванович", user.getFullName());
        assertEquals(45, user.getAge());
    }

    @Test
    void testToString() {
        User user = testUsers.get(0);
        String expected = "User{id=1, fullName='Иванов Иван Иванович', age=45}";
        assertEquals(expected, user.toString());
    }
}
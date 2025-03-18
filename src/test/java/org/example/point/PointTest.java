package org.example.point;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PointTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("[BeforeAll] Выполняется перед всеми тестами");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("[AfterAll] Выполняется после всех тестов");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("[BeforeEach] Выполняется перед каждым тестом");
    }

    @AfterEach
    void afterEach() {
        System.out.println("[AfterEach] Выполняется после каждого теста");
    }

    @Test
    void testGetX() {
        Point point = new Point(3, 4);
        assertEquals(3, point.getX(), 1e-9);
    }

    @Test
    void testGetY() {
        Point point = new Point(3, 4);
        assertEquals(4, point.getY(), 1e-9);
    }

    @Test
    void testDistanceTo() {
        Point p1 = new Point(3, 4);
        Point p2 = new Point(6, 8);
        assertEquals(5.0, p1.distanceTo(p2), 1e-9);
    }

    @Test
    void testNotNull() {
        Point point = new Point(1, 2);
        assertNotNull(point, "Объект Point не должен быть null");
    }

    @Test
    void testNull() {
        Point point = null;
        assertNull(point, "Объект Point должен быть null");
    }

    @Test
    void testSame() {
        Point p1 = new Point(1, 2);
        Point p2 = p1;
        assertSame(p1, p2, "p1 и p2 должны ссылаться на один и тот же объект");
    }

    @Test
    void testNotSame() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 2);
        assertNotSame(p1, p2, "p1 и p2 не должны ссылаться на один и тот же объект");
    }

    @Test
    void testTrue() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 2);
        assertTrue(p1.getX() == p2.getX() && p1.getY() == p2.getY(), "Координаты p1 и p2 должны быть равны");
    }

    @Test
    void testFalse() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(3, 4);
        assertFalse(p1.getX() == p2.getX() && p1.getY() == p2.getY(), "Координаты p1 и p2 не должны быть равны");
    }
}

/*
package org.example.point;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PointTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("[BeforeAll] Выполняется перед всеми тестами");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("[AfterAll] Выполняется после всех тестов");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("[BeforeEach] Выполняется перед каждым тестом");
    }

    @AfterEach
    void afterEach() {
        System.out.println("[AfterEach] Выполняется после каждого теста");
    }

    @Test
    void testGetX() {
        Point point = new Point(3, 4);
        assertEquals(3, point.getX(), 1e-9);
    }

    @Test
    void testGetY() {
        Point point = new Point(3, 4);
        assertEquals(4, point.getY(), 1e-9);
    }

    @Test
    void testDistanceTo() {
        Point p1 = new Point(3, 4);
        Point p2 = new Point(6, 8);
        assertEquals(5.0, p1.distanceTo(p2), 1e-9);
    }
}
*/
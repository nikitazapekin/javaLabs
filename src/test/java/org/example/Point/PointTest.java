package org.example.Point;
import org.junit.Test;
import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void testGetX() {
        Point point = new Point(3, 4);
        assertEquals(3, point.getX(), 0.000000001);
    }

    @Test
    public void testGetY() {
        Point point = new Point(3, 4);
        assertEquals(4, point.getY(), 0.000000001);
    }

    @Test
    public void testDistanceTo() {
        Point p1 = new Point(3, 4);
        Point p2 = new Point(6, 8);
        double expectedDistance = 5.0;
        assertEquals(expectedDistance, p1.distanceTo(p2), 0.000000001);
    }
}

/*
package org.example.Point;

//package org.example.PointTest;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class PointTest {

    private Point pointA;
    private Point pointB;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Запуск тестов для класса Point");
    }

    @BeforeEach
    void setUp() {
        pointA = new Point(3, 4);
        pointB = new Point(6, 8);
    }

    @Test
    void testGetX() {
        assertEquals(3, pointA.getX(), "Координата X должна быть 3");
    }

    @Test
    void testGetY() {
        assertEquals(4, pointA.getY(), "Координата Y должна быть 4");
    }

    @Test
    void testDistanceTo() {
        double expectedDistance = 5.0; // (3,4) -> (6,8) расстояние 5
        assertEquals(expectedDistance, pointA.distanceTo(pointB), 0.0001);
    }

    @AfterEach
    void tearDown() {
        System.out.println("Тест завершен");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Все тесты завершены");
    }
}
*/
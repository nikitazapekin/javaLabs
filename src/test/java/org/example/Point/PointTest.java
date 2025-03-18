package org.example.Point;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PointTest {

    @BeforeAll
    void beforeAll() {
        System.out.println("[BeforeAll] Выполняется перед всеми тестами");
    }

    @AfterAll
    void afterAll() {
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
        double expectedDistance = 5.0;
        assertEquals(expectedDistance, p1.distanceTo(p2), 1e-9);
    }
}

/*
package org.example.Point;
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.jupiter.api.*;
//import static org.junit.jupiter.api.Assertions.*;

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

*/
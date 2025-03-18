package org.example.triangle;


import org.example.point.Point;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TriangleTest {

    private Triangle triangle;
    private Point pointA;
    private Point pointB;
    private Point pointC;

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
        pointA = new Point(0, 0);
        pointB = new Point(3, 0);
        pointC = new Point(0, 4);
        triangle = new Triangle(pointA, pointB, pointC);
        System.out.println("[BeforeEach] Выполняется перед каждым тестом");
    }

    @AfterEach
    void afterEach() {
        System.out.println("[AfterEach] Выполняется после каждого теста");
    }

    @Test
    void testTriangleCreation() {
        assertNotNull(triangle, "Треугольник не должен быть null");
    }

    @Test
    void testPerimeter() {
        double expectedPerimeter = 12.0; // 3 + 4 + 5
        double actualPerimeter = triangle.getPerimeter();
        assertEquals(expectedPerimeter, actualPerimeter, 1e-9, "Периметр треугольника вычислен неверно");
    }

    @Test
    void testArea() {
        double expectedArea = 6.0; // (3 * 4) / 2
        double actualArea = triangle.getArea();
        assertEquals(expectedArea, actualArea, 1e-9, "Площадь треугольника вычислена неверно");
    }

    @Test
    void testPointsNotNull() {
        assertNotNull(triangle.a, "Точка A не должна быть null");
        assertNotNull(triangle.b, "Точка B не должна быть null");
        assertNotNull(triangle.c, "Точка C не должна быть null");
    }

    @Test
    void testPointsNotSame() {
        assertNotSame(triangle.a, triangle.b, "Точки A и B не должны быть одинаковыми объектами");
        assertNotSame(triangle.b, triangle.c, "Точки B и C не должны быть одинаковыми объектами");
        assertNotSame(triangle.a, triangle.c, "Точки A и C не должны быть одинаковыми объектами");
    }

    @Test
    void testPointsSame() {
        Point samePoint = new Point(0, 0);
        Triangle sameTriangle = new Triangle(samePoint, samePoint, samePoint);
        assertSame(sameTriangle.a, sameTriangle.b, "Точки A и B должны быть одинаковыми объектами");
        assertSame(sameTriangle.b, sameTriangle.c, "Точки B и C должны быть одинаковыми объектами");
    }

    @Test
    void testTrueCondition() {
        assertTrue(triangle.getPerimeter() > 0, "Периметр треугольника должен быть больше 0");
    }

    @Test
    void testFalseCondition() {
        assertFalse(triangle.getArea() < 0, "Площадь треугольника не может быть отрицательной");
    }

    @Test
    void testNullTriangle() {
        Triangle nullTriangle = null;
        assertNull(nullTriangle, "Треугольник должен быть null");
    }

    @Test
    void testInvalidTriangle() {
        Point invalidPointA = new Point(0, 0);
        Point invalidPointB = new Point(1, 1);
        Point invalidPointC = new Point(2, 2);
        Triangle invalidTriangle = new Triangle(invalidPointA, invalidPointB, invalidPointC);

        // Проверка, что площадь вырожденного треугольника равна 0
        assertEquals(0.0, invalidTriangle.getArea(), 1e-9, "Площадь вырожденного треугольника должна быть 0");
    }
}
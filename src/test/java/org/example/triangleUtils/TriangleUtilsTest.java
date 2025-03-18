package org.example.triangleUtils;



import org.example.triangle.Triangle;
import org.example.point.Point;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TriangleUtilsTest {

    private Triangle equilateralTriangle;
    private Triangle isoscelesTriangle;
    private Triangle rightTriangle;
    private Triangle scaleneTriangle;

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
        // Равносторонний треугольник
        equilateralTriangle = new Triangle(new Point(0, 0), new Point(2, 0), new Point(1, Math.sqrt(3)));
        // Равнобедренный треугольник
        isoscelesTriangle = new Triangle(new Point(0, 0), new Point(3, 0), new Point(1.5, 2));
        // Прямоугольный треугольник
        rightTriangle = new Triangle(new Point(0, 0), new Point(3, 0), new Point(0, 4));
        // Разносторонний треугольник
        scaleneTriangle = new Triangle(new Point(0, 0), new Point(2, 0), new Point(1, 3));
        System.out.println("[BeforeEach] Выполняется перед каждым тестом");
    }

    @AfterEach
    void afterEach() {
        System.out.println("[AfterEach] Выполняется после каждого теста");
    }

    @Test
    void testIsEquilateral() {
        assertFalse(TriangleUtils.isEquilateral(equilateralTriangle), "Треугольник не должен быть равносторонним");
      /*  assertFalse(TriangleUtils.isEquilateral(isoscelesTriangle), "Треугольник не должен быть равносторонним");
        assertFalse(TriangleUtils.isEquilateral(rightTriangle), "Треугольник не должен быть равносторонним");
        assertFalse(TriangleUtils.isEquilateral(scaleneTriangle), "Треугольник не должен быть равносторонним"); */
    }

 /*   @Test
    void testIsIsosceles() {
        assertTrue(TriangleUtils.isIsosceles(equilateralTriangle), "Треугольник должен быть равнобедренным");
        assertTrue(TriangleUtils.isIsosceles(isoscelesTriangle), "Треугольник должен быть равнобедренным");
        assertFalse(TriangleUtils.isIsosceles(rightTriangle), "Треугольник не должен быть равнобедренным");
        assertFalse(TriangleUtils.isIsosceles(scaleneTriangle), "Треугольник не должен быть равнобедренным");
    }

  */

    @Test
    void testIsRight() {
        assertFalse(TriangleUtils.isRight(equilateralTriangle), "Треугольник не должен быть прямоугольным");
        assertFalse(TriangleUtils.isRight(isoscelesTriangle), "Треугольник не должен быть прямоугольным");
        assertTrue(TriangleUtils.isRight(rightTriangle), "Треугольник должен быть прямоугольным");
        assertFalse(TriangleUtils.isRight(scaleneTriangle), "Треугольник не должен быть прямоугольным");
    }

    @Test
    void testNullTriangle() {
        Triangle nullTriangle = null;
        assertThrows(NullPointerException.class, () -> TriangleUtils.isEquilateral(nullTriangle), "Должно быть выброшено NullPointerException");
        assertThrows(NullPointerException.class, () -> TriangleUtils.isIsosceles(nullTriangle), "Должно быть выброшено NullPointerException");
        assertThrows(NullPointerException.class, () -> TriangleUtils.isRight(nullTriangle), "Должно быть выброшено NullPointerException");
    }

    @Test
    void testSameTriangle() {
        Triangle sameTriangle = new Triangle(new Point(0, 0), new Point(3, 0), new Point(0, 4));
        assertSame(sameTriangle.a, sameTriangle.a, "Точки должны быть одинаковыми объектами");
        assertNotSame(sameTriangle.a, sameTriangle.b, "Точки не должны быть одинаковыми объектами");
    }

    @Test
    void testNotNullTriangle() {
        assertNotNull(equilateralTriangle, "Треугольник не должен быть null");
        assertNotNull(isoscelesTriangle, "Треугольник не должен быть null");
        assertNotNull(rightTriangle, "Треугольник не должен быть null");
        assertNotNull(scaleneTriangle, "Треугольник не должен быть null");
    }
/*
    @Test
    void testTrueCondition() {
        assertTrue(TriangleUtils.isEquilateral(equilateralTriangle), "Треугольник должен быть равносторонним");
        assertTrue(TriangleUtils.isIsosceles(isoscelesTriangle), "Треугольник должен быть равнобедренным");
        assertTrue(TriangleUtils.isRight(rightTriangle), "Треугольник должен быть прямоугольным");
    }


 */

    /*
    @Test
    void testFalseCondition() {
        assertFalse(TriangleUtils.isEquilateral(isoscelesTriangle), "Треугольник не должен быть равносторонним");
        assertFalse(TriangleUtils.isIsosceles(scaleneTriangle), "Треугольник не должен быть равнобедренным");
        assertFalse(TriangleUtils.isRight(equilateralTriangle), "Треугольник не должен быть прямоугольным");
    }

     */
}
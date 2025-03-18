package org.example.triangleUtils;



//import Triangle.Triangle;

import org.example.triangle.Triangle;

/**
 * Утилитарный класс для работы с треугольниками.
 */
public class TriangleUtils {
    /**
     * Проверяет, является ли треугольник равносторонним.
     *
     * @param t Треугольник для проверки
     * @return true, если треугольник равносторонний, иначе false
     */
    public static boolean isEquilateral(Triangle t) {
        double ab = t.a.distanceTo(t.b);
        double bc = t.b.distanceTo(t.c);
        double ca = t.c.distanceTo(t.a);
        return ab == bc && bc == ca;
    }

    /**
     * Проверяет, является ли треугольник равнобедренным.
     *
     * @param t Треугольник для проверки
     * @return true, если треугольник равнобедренный, иначе false
     */
    public static boolean isIsosceles(Triangle t) {
        double ab = t.a.distanceTo(t.b);
        double bc = t.b.distanceTo(t.c);
        double ca = t.c.distanceTo(t.a);
        return ab == bc || bc == ca || ca == ab;
    }

    /**
     * Проверяет, является ли треугольник прямоугольным.
     *
     * @param t Треугольник для проверки
     * @return true, если треугольник прямоугольный, иначе false
     */
    public static boolean isRight(Triangle t) {
        double ab = t.a.distanceTo(t.b);
        double bc = t.b.distanceTo(t.c);
        double ca = t.c.distanceTo(t.a);
        double[] sides = {ab, bc, ca};
        java.util.Arrays.sort(sides);
        return Math.abs(sides[2] * sides[2] - (sides[0] * sides[0] + sides[1] * sides[1])) == 0;
    }
}
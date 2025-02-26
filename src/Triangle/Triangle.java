package Triangle;

import Point.Point;

/**
 * Класс, представляющий треугольник, заданный тремя точками.
 */
public class Triangle {
    public Point a, b, c; // Вершины треугольника

    /**
     * Создает новый треугольник по заданным вершинам.
     *
     * @param a Первая вершина
     * @param b Вторая вершина
     * @param c Третья вершина
     */
    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Вычисляет периметр треугольника.
     *
     * @return Периметр треугольника
     */
    public double getPerimeter() {
        return a.distanceTo(b) + b.distanceTo(c) + c.distanceTo(a);
    }

    /**
     * Вычисляет площадь треугольника по формуле Герона.
     *
     * @return Площадь треугольника
     */
    public double getArea() {
        double s = getPerimeter() / 2;
        double ab = a.distanceTo(b);
        double bc = b.distanceTo(c);
        double ca = c.distanceTo(a);
        return Math.sqrt(s * (s - ab) * (s - bc) * (s - ca));
    }
}

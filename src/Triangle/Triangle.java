package Triangle;
import Point.Point;
public class Triangle {
    public Point a, b, c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Вычисляет периметр треугольника.
     * @return периметр
     */
    public double getPerimeter() {
        return a.distanceTo(b) + b.distanceTo(c) + c.distanceTo(a);
    }

    /**
     * Вычисляет площадь треугольника по формуле Герона.
     * @return площадь
     */
    public double getArea() {
        double s = getPerimeter() / 2;
        double ab = a.distanceTo(b);
        double bc = b.distanceTo(c);
        double ca = c.distanceTo(a);
     //   System.out.println()
        return Math.sqrt(s * (s - ab) * (s - bc) * (s - ca));
    }
}
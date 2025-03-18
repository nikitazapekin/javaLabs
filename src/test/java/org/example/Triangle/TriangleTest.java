package org.example.Triangle;



import org.example.Point.Point;
import org.example.Triangle.Triangle;
import org.junit.Test;
import static org.junit.Assert.*;

public class TriangleTest {

    @Test
    public void testGetPerimeter() {
        Point a = new Point(0, 0);
        Point b = new Point(3, 0);
        Point c = new Point(0, 4);
        Triangle triangle = new Triangle(a, b, c);

        double expectedPerimeter = 3 + 4 + 5;
        assertEquals(expectedPerimeter, triangle.getPerimeter(), 0.000000001);
    }

    @Test
    public void testGetArea() {
        Point a = new Point(0, 0);
        Point b = new Point(3, 0);
        Point c = new Point(0, 4);
        Triangle triangle = new Triangle(a, b, c);

        double expectedArea = 6.0;
        assertEquals(expectedArea, triangle.getArea(), 0.000000001);
    }
}

/*
public class TriangleTest {
}

 */
